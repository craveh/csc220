package lab13;

import java.util.ArrayList;

public class WordFisherTester {
	
	public static void main(String[] args) {
		//System.out.println("Testing");
		
		WordFisher moby = new WordFisher("moby-dick.txt", "stopwords.txt");
		WordFisher alice = new WordFisher("carroll-alice.txt", "stopwords.txt"); 
		
		//moby.printStopwords();
		System.out.println('\n' +"Testing getWordCount");
		System.out.println( "moby word count:" + moby.getWordCount());
		System.out.println("alice word count:" + alice.getWordCount());
		
		
		System.out.println('\n' +"Testing getNumUniqueWords");
		System.out.println(moby.getNumUniqueWords());
		System.out.println(alice.getNumUniqueWords());
		
		System.out.println('\n' + "Testing getFrequency");
		System.out.println("whale, moby " + moby.getFrequency("whale"));
		System.out.println("handkerchief, moby " + moby.getFrequency("handkerchief"));
		System.out.println("whale, alice " + alice.getFrequency("whale"));
		System.out.println("handkerchief, alice " + alice.getFrequency("handkerchief"));
		
		
		System.out.println('\n' + "Testing # num words after pruneVocabulary");
		moby.pruneVocabulary();
		alice.pruneVocabulary();
		System.out.println(moby.getWordCount());
		System.out.println(alice.getWordCount());
		
		System.out.println('\n' + "Testing getTopWords");
		System.out.println("Moby: ");
		moby.printTopWords(moby.getTopWords(10));
		System.out.println("Alice: ");
		alice.printTopWords(alice.getTopWords(10));
		
		System.out.println('\n' + "Testing getTopWords");
		moby.printTopCommonWords(moby.commonPopularWords(20, alice));
		
		
		
		

		
		
	}

}
