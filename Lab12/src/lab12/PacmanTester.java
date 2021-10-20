package lab12;

public class PacmanTester {

    public static void main(String[] args) {
    	
    	//The first file name was changed to test each maze available
    	Pacman test1 = new Pacman("tinyOpen.txt", "outputMaze.txt");
    	
    	
    	test1.print();
    	test1.start();
    	
    	//test1.solveBFS();
    	System.out.println("Testing BFS method");
    	//test1.print();
    	
    	test1.solveDFS();
    	System.out.println("Testing DFS method");
    	test1.print();
    	
    	
    	
    }

}
