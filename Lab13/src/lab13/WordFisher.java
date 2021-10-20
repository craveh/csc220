package lab13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;



public class WordFisher {
	
	public HashMap<String, Integer> vocabulary;
	private List<String> stopwords;
	private String inputTextFile;
	private String stopwordsFile;
	
	/**
	 * Initiallizes the member variables
	 * 
	 * @param inputTextFile the name of text file being analyzed
	 * @param stopwordsFile the file containing the list of words to be filtered out
	 */
	public WordFisher(String inputTextFile, String stopwordsFile) {
		this.inputTextFile = inputTextFile;
		this.stopwordsFile = stopwordsFile;
		
		getStopwords();
		buildVocabulary();
		
	}
	/**
	 * Creates the list of stopwords
	 */
	private void getStopwords() {
		
		stopwords =  new ArrayList<String>();
		
		try{
			BufferedReader input = new BufferedReader(
					new FileReader(stopwordsFile));
			String word = input.readLine();
			while(word != null) {
				stopwords.add(word);
				word = input.readLine();
				
			}
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	/**
	 * Method that loops through and prints the stopwords
	 */

	public void printStopwords() {
		for(int i =0; i<stopwords.size(); i++) {
			System.out.println(stopwords.get(i));
		}
		
	}
	
	/**
	 * Removes all non-alphanumeric characters
	 * Builds the HashMap with keys being word and value being word frequency in text
	 */
	private void buildVocabulary() {
		vocabulary = new HashMap<String, Integer>();
		String temp = "";
		
		try {
			String reader = new String(Files.readAllBytes(Paths.get(inputTextFile)));
			reader = reader.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
			reader = reader.trim();
			
			
			String[] allWords = reader.split("\\s+");
			
			//System.out.println(allWords.length);
			
			//System.out.println("0" + allWords[0]);
			//System.out.println("1" + allWords[1]);
			
			for(int i=0; i<allWords.length; i++) {
				temp = allWords[i];
				
				if(vocabulary.containsKey(temp)) {
					int val = vocabulary.get(temp) + 1;
					vocabulary.put(temp, val);
				}else {
					vocabulary.put(temp, 1);
					
				}
				
			}
			
			writeOutput(allWords);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//System.out.println("Size of map =  " + vocabulary.size());
		//System.out.println("Counter: " + counter);
	}
	
	
	public void writeOutput(String[] arr) {
		try {
			PrintWriter output = new PrintWriter(new FileWriter("test.txt"));
			
			for(int i =0; i<arr.length; i++) {
				output.println(arr[i]);
			}
			
			output.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeOutput(Integer[] arr) {
		try {
			PrintWriter output = new PrintWriter(new FileWriter("test.txt"));
			
			for(int i =0; i<arr.length; i++) {
				output.println(arr[i]);
			}
			
			output.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Gets the total amount of word in the text
	 * @return number of words
	 */
	public int getWordCount() {
		
		Collection<Integer> value = vocabulary.values();
		//System.out.println(value.size());
		Integer[] temp = new Integer[value.size()];
		Integer[] values = value.toArray(temp);
		//System.out.println(values.length);
		
		int counter = 0;
		for(int i=0; i<values.length; i++) {
			counter += values[i];
		}

		return counter;
		
	}
	/**
	 * Gets the number of unique words in the text file
	 * @return number of unique words
	 */
	public int getNumUniqueWords() {
		
		return(vocabulary.size());
		
	}
	/**
	 * Tests the frequency of a word 
	 * 
	 * @param word - that we are checking how often is used
	 * @return - the frequency of the word inputted
	 */
	public int getFrequency(String word) {

		if(vocabulary.containsKey(word)) {
			return (vocabulary.get(word));
			
		}else {
			return -1;
			
		}
		
	}
	
	/**
	 * removes all stopwords from the vocabulary map
	 */
	public void pruneVocabulary() {
		for(int i = 0; i<stopwords.size(); i++) {
			//String word = stop
			if(vocabulary.containsKey(stopwords.get(i))) {
				vocabulary.remove(stopwords.get(i));
			}
		}
		
	}
	
	/**
	 * 
	 * @author Hannah Raveh
	 * this class is used to store nodes of words and their
	 * frequencies that will be used in a PriorityQueue
	 *
	 */
	
	private static class WordNode {
		
		private String word;
		private int frequency;
		
		public WordNode(String word, int frequency) {
			this.word =  word;
			this.frequency = frequency;
			
		}
		
		
		
		
	}
	/**
	 * 
	 * @author Hannah Raveh
	 * The comparator the PriorityQueue will use
	 *
	 */
	
	protected class WordNodeComparator implements Comparator<WordNode> {
		// FILL IN - write the compare method
		  public int compare(WordNode L, WordNode R) {
			  if(L.frequency == R.frequency) {
				  return 0;
			  }else if(L.frequency > R.frequency) {
				  return -1;
			  }else {
				  return 1;
			  }
			  

		  }

	   	  
	  }
	/**
	 * Gets the top n most frequently used words
	 * @param n - the amount of top frequent words we want
	 * @return - an ArrayList of the top n frequent words
	 */
	public ArrayList<String> getTopWords(int n){
		ArrayList<String> topWords = new ArrayList<String>();
		WordNodeComparator comp = new WordNodeComparator();
		PriorityQueue<WordNode> pQueue = new PriorityQueue(vocabulary.size(), comp);
		
		Iterator<Map.Entry<String, Integer>> iterator = vocabulary.entrySet().iterator();
		
		while(iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			WordNode node = new WordNode(entry.getKey(), entry.getValue());
			pQueue.add(node);
		}
		
		for(int i = 0; i<n; i++) {
			WordNode temp = pQueue.poll();
			topWords.add(temp.word);
		}
		
		return topWords;
	}
	
	public void printTopWords(ArrayList<String> topwords) {
		System.out.println("Top Words:");
		for(int i = 0; i<topwords.size(); i++) {
			System.out.println(topwords.get(i) + " "  + vocabulary.get(topwords.get(i)));
			
		}
		System.out.println();
	}
	
	/**
	 * Gets the n most popular words from this object, and n most popular
	 * words from the WordFisher objected inputted.
	 * Return an ArrayList of the words they have in common
	 * 
	 * @param n - the amount of top frequent words we want
	 * @param other - the WordFisher object we are comparing to
	 * @return the arraylist of the the n most popular words between the
	 */
	public ArrayList<String> commonPopularWords(int n, WordFisher other){
		ArrayList<String> common = new ArrayList<String>();
		
		ArrayList<String> thisObj = this.getTopWords(n);
		
		ArrayList<String> otherObj = other.getTopWords(n);
		
		for(int i =0; i< n; i++) {
			if(otherObj.contains(thisObj.get(i))) {
				common.add(thisObj.get(i));
			}
		}
		
		return common;
		
	}
	
	public void printTopCommonWords(ArrayList<String> commonTopwords) {
		System.out.println("Common Top Words:");
		for(int i = 0; i<commonTopwords.size(); i++) {
			System.out.println(commonTopwords.get(i));
			
		}
		System.out.println();
	}
	
	

}
