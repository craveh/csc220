package lab12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class Pacman {

	/** representation of the graph as a 2D array */
	private Node[][] maze;
	/** input file name */
	private String inputFileName;
	/** output file name */
	private String outputFileName;
	/** height and width of the maze */
	private int height;
	private int width;
	/** starting (X,Y) position of Pacman */
	private int startX;
	private int startY;

	/** A Node is the building block for a Graph. */
	private static class Node {
		/** the content at this location */
	    private char content;
	    /** the row where this location occurs */
	    private int row;
	    /** the column where this location occurs */
	    private int col;
		private boolean visited;
		private Node parent;

	    public Node(int x, int y, char c) {
	        visited = false;
	        content = c;
	        parent =  null;
	        this.row = x;
	        this.col = y;
	    }

	    public boolean isWall() { return content == 'X'; }
	    public boolean isVisited() { return visited; }
	}

	/** constructor */
	public Pacman(String inputFileName, String outputFileName) {
		this.inputFileName = inputFileName;
		this.outputFileName = outputFileName;
		buildGraph();
	}

	private boolean inMaze(int index, int bound){
		return index < bound && index >= 0;
	}

	/** helper method to construct the solution path from S to G
	 *  NOTE this path is built in reverse order, starting with the goal G.
	*/
	private void backtrack(Node end){
		// TODO for assignment12
		Node back = end.parent;
		while(back.content != 'S') {
			back.content = '.';
			back = back.parent;
			
		}
		
	}

	/** writes the solution to file */
	public void writeOutput() {
		// TODO for lab12
		try {
			PrintWriter output = new PrintWriter(new FileWriter(outputFileName));
			// FILL IN
			output.print(height + " " + width);
			output.println();
			for(int i =0; i<height; i++) {
				for(int j= 0; j<width; j++) {
					output.print(maze[i][j].content);
				}
				output.println();
			}
			
			
			output.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public String toString() {
		String s = "";
		s += height + " " + width + "\n";
		for (int i = 0; i < height; i++){
			for (int j = 0; j < width; j++){
				s += maze[i][j].content + " ";
			}
			s += "\n";
		}
		return s;
	}

	/** helper method to construct a graph from a given input file;
	 *  all member variables (e.g. maze, startX, startY) should be
	 *  initialized by the end of this method
	 */
	private void buildGraph() {
		// TODO for lab12
		try {
			// don't forget to close input when you're done
			BufferedReader input = new BufferedReader(
				new FileReader(inputFileName));
			// FILL IN
			String[] dimension = input.readLine().split(" ");
			height = Integer.parseInt(dimension[0]);
			width = Integer.parseInt(dimension[1]);
			
			maze  = new Node[height][width];
			
			for(int i=0; i<height; i++) {
				String line = input.readLine();
				//String[] info = line.split("");
				for(int j=0; j<width; j++) {
					char c = line.charAt(j);
					maze[i][j]  = new Node(i, j, c);
					if(c == 'S') {
						startX = i;
						startY = j;	
					}
					
				}
			}
			
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * Alternative toString cuz I don't like the 1 provided
	 */
	public void print() {
		System.out.println(height + " " + width);
		for(int i =0; i<height; i++) {
			for(int j= 0; j<width; j++) {
				System.out.print(maze[i][j].content);
			}
			System.out.println();
		}
		
	}
	/**
	 * check that startx  and starty are assigned properly
	 */
	public void start() {
		System.out.println("Start from: (" + startX  + ", " + startY + ")");
	}

	/** obtains all neighboring nodes that have *not* been
	 *  visited yet from a given node when looking at the four
	 *  cardinal directions: North, South, West, East (IN THIS ORDER!)
	 *
	 * @param currentNode the given node
	 * @return an ArrayList of the neighbors (i.e., successors)
	 */
	public ArrayList<Node> getNeighbors(Node currentNode) {
		// TODO for assignment12
		Node north, south, east, west;
		// 0. Initialize an ArrayList of nodes
		ArrayList<Node> neighbors = new ArrayList<Node>();
		int nodeRow = currentNode.row;
		int nodeCol = currentNode.col;
		
		if(currentNode.isWall()) {
			return null;
		}
		Node tempNode = currentNode;

		// 1. Inspect the north neighbor
		tempNode = maze[nodeRow-1][nodeCol];
		if(!tempNode.isWall() && !tempNode.isVisited()) {
			tempNode.visited = true;
			tempNode.parent = currentNode;
			neighbors.add(tempNode);
			
		}

		// 2. Inspect the south neighbor
		tempNode = maze[nodeRow+1][nodeCol];
		if(!tempNode.isWall() && !tempNode.isVisited()) {
			tempNode.visited = true;
			tempNode.parent = currentNode;
			neighbors.add(tempNode);
			
		}

		// 3. Inspect the west neighbor
		tempNode = maze[nodeRow][nodeCol-1];
		if(!tempNode.isWall() && !tempNode.isVisited()) {
			tempNode.visited = true;
			tempNode.parent = currentNode;
			neighbors.add(tempNode);
			
		}

		// 4. Inspect the east neighbor
		tempNode = maze[nodeRow][nodeCol+1];
		if(!tempNode.isWall() && !tempNode.isVisited()) {
			tempNode.visited = true;
			tempNode.parent = currentNode;
			neighbors.add(tempNode);
			
		}

		return neighbors;
	}

	/** Pacman uses BFS strategy to solve the maze */
	public void solveBFS() {
		// TODO for assignment12
		Queue<Node> nodes = new LinkedList<Node>();
		ArrayList<Node> neighbors = new ArrayList<Node>();
		
		Node start = maze[startX][startY];
		
		nodes.offer(start);
		start.visited = true;
		
		while(nodes.size() != 0) {
			Node temp = nodes.poll();
			if(temp.content == 'G') {
				backtrack(temp);
				break;
			}
			neighbors = getNeighbors(temp);
			for(int i= 0; i< neighbors.size(); i++) {
				nodes.offer(neighbors.get(i));
			}
	
		}
		writeOutput();
		
	}

	/** Pacman uses DFS strategy to solve the maze */
	public void solveDFS() {
		// TODO for assignment12
		Stack<Node> nodes = new Stack<Node>();
		ArrayList<Node> neighbors = new ArrayList<Node>();
		Node start = maze[startX][startY];
		
		nodes.push(start);
		start.visited = true;
		
		Node current = start;
		
		while(!nodes.empty()) {
			Node temp = nodes.pop();
			
			if(temp.content =='G') {
				backtrack(temp);
				break;
			}
			
			neighbors = getNeighbors(temp);
			for(int i= 0; i< neighbors.size(); i++) {
				nodes.push(neighbors.get(i));
			}
		
		}
		
		writeOutput();
	}
	
	

}
