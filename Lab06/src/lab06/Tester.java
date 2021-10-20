package lab06;

public class Tester {
	public static void main(String[] args) {
		
//Test that SortedString constructor works properly
		SortedString test1 = new SortedString("yellow");
		System.out.println(test1);
		// Worked
		
//Test the compareTo() method
		SortedString comp1 = new SortedString("joy");
		SortedString comp2 = new SortedString("ski");
		int compared1 = comp1.compareTo(comp2);
		//Should print out 1 cuz comp1 > comp2 j>i
//		System.out.println(compared1 + "\n" + comp1 + "\n" + comp2);
		
		SortedString comp3 = new SortedString("below");
		SortedString comp4 = new SortedString("Elbow");
		
		int compared2 = comp3.compareTo(comp4);
		//Should print out 0 cuz are anagrams so equal
//		System.out.println(compared2 + "\n" + comp3 + "\n" + comp4);
	
//Test areAnagrams
		//AnagramUtil testAnagrams = new AnagramUtil();
		//Test same String - check is case sensitive
		SortedString name = new SortedString("Hannah");
		SortedString nameRev = new SortedString("hannah");
		
		if(!AnagramUtil.areAnagrams(name, nameRev)) {
			System.err.println("Error in areAnagrams() method");
		}
		//Test 2 diff strings
		SortedString lastName = new SortedString("Raveh");
		if(AnagramUtil.areAnagrams(name, lastName)) {
			System.err.println("Error in areAnagrams() method");
		}
		//Test String and empty string
		SortedString emptyStr = new SortedString("");
		if(AnagramUtil.areAnagrams(name, emptyStr)) {
			System.err.println("Error in areAnagrams() method");
		}
		// String + shuffled string
		SortedString shuffleLast = new SortedString("ahrev");
		if(!AnagramUtil.areAnagrams(lastName,shuffleLast)) {
			System.err.println("Error in areAnagrams() method");
		}
	
//Test Sort from insertion sort:
		// 1 element
		InsertionSort<SortedString> testInsertion = new InsertionSort<SortedString>();
		SortedString[] unsortedArr0 = new SortedString[] {name};
		SortedString[] sortedArr0 = testInsertion.sort(unsortedArr0);
		
		for(int i= 0; i<sortedArr0.length; i++) {
			System.out.print(sortedArr0[i] + "  ");
		} 
		System.out.println();
		
		//2 elements
		
		SortedString[] unsortedArr1 = new SortedString[] {name, lastName};
		SortedString[] sortedArr1 = testInsertion.sort(unsortedArr1);
		
		for(int i= 0; i<sortedArr1.length; i++) {
			System.out.print(sortedArr1[i] + "  ");
		} 
		System.out.println();
		
		//Sorted list of numbers
		InsertionSort<Integer> testInsertion1 = new InsertionSort<Integer>();
		Integer[] integerArr = new Integer[] {5,7, 19, 25};
		Integer[] sortedIntegerArr = testInsertion1.sort(integerArr);
		for(int i = 0; i<sortedIntegerArr.length; i++) {
			System.out.print(sortedIntegerArr[i] + "   ");
		}System.out.println();
		
		//Unsorted array of numbers
		Integer[] integerArr1 = new Integer[] {7, 5, 13, 12};
		Integer[] sortedIntegerArr1 = testInsertion1.sort(integerArr1);
		for(int i = 0; i<sortedIntegerArr1.length; i++) {
			System.out.print(sortedIntegerArr1[i] + "   ");
		}System.out.println();
		
		//Array of SortedString
		String[] stringArray = new String[] {"cat", "apple","banana","orange", "zoo","act"};
		
	
		SortedString[] unsortedArr = SortedString.toSortedString(stringArray);
		SortedString[] sortedArr = testInsertion.sort(unsortedArr);
		
		for(int i= 0; i<sortedArr.length; i++) {
			System.out.print(sortedArr[i] + "  ");
		}
		System.out.println();
		
// Test timing stuff
		String[] stringArrayTime = new String[] {"cat", "apple","banana","orange", "zoo","act","something", "fall", "spring", "pry", "phone"};
		SortedString[] unsortedArrTime = SortedString.toSortedString(stringArrayTime);
		testInsertion.fit(unsortedArrTime);
		int n = 1000000;
		double time = testInsertion.predict(n);
		System.out.println(time);
		

//	LargestAnagramGroup Testing
		System.out.println();
		System.out.println();
		
		//Test list of words provided
		String[] anagramGroup = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		for(int i=0; i< anagramGroup.length; i++) {
			System.out.print(anagramGroup[i] + "  ");
		}
		System.out.println();
		//Empty file w/ test_file.txt
		anagramGroup = AnagramUtil.getLargestAnagramGroup("test_file.txt");
		System.out.println(anagramGroup);
		//file w/ 1 word
		
		anagramGroup = AnagramUtil.getLargestAnagramGroup("test_file_2.txt");
		for(int i=0; i< anagramGroup.length; i++) {
			System.out.print(anagramGroup[i] + "  ");
		}
		
		
		
//MergeSorts Sort method testing
	System.out.println();
	System.out.println();
	
		System.out.println("Testing MergeSort");
		
		// 1 element
				MergeSort<SortedString> testMerge = new MergeSort<SortedString>();
				SortedString[] unsortedArrM = new SortedString[] {name};
				SortedString[] sortedArrM = testInsertion.sort(unsortedArrM);
				
				for(int i= 0; i<sortedArrM.length; i++) {
					System.out.print(sortedArrM[i] + "  ");
				} 
				System.out.println();
				
				//2 elements
				
				SortedString[] unsortedArr2 = new SortedString[] {name, lastName};
				SortedString[] sortedArr2 = testMerge.sort(unsortedArr2);
				
				for(int i= 0; i<sortedArr2.length; i++) {
					System.out.print(sortedArr1[i] + "  ");
				} 
				System.out.println();
				
				//Sorted list of numbers
				MergeSort<Integer> testMerge1 = new MergeSort<Integer>();
				Integer[] integerArr2 = new Integer[] {5,7, 19, 25};
				Integer[] sortedIntegerArr2 = testMerge1.sort(integerArr2);
				for(int i = 0; i<sortedIntegerArr2.length; i++) {
					System.out.print(sortedIntegerArr2[i] + "   ");
				}System.out.println();				
				//Unsorted array of numbers
				Integer[] integerArr3 = new Integer[] {7, 5, 13, 12};
				Integer[] sortedIntegerArr3 = testMerge1.sort(integerArr3);
				for(int i = 0; i<sortedIntegerArr3.length; i++) {
					System.out.print(sortedIntegerArr3[i] + "   ");
				}System.out.println();
				
				//A
			
				SortedString[] sortedArr7 = testMerge.sort(unsortedArr);
				
				for(int i= 0; i<sortedArr.length; i++) {
					System.out.print(sortedArr7[i] + "  ");
				}
				System.out.println();
		
		
				//String[] stringArrayTimeMerge = new String[] {"cat", "apple","banana","orange", "zoo","act","something", "fall", "spring", "pry", "phone"};
				//SortedString[] unsortedArrTimeMerge = SortedString.toSortedString(stringArrayTime);
				testMerge.fit(unsortedArrTime);
				int nMerge = 1000000;
				double timeMerge = testMerge.predict(nMerge);
				System.out.println(timeMerge);
		
	
	
	
	
	System.out.println( "\n"+"Testing Done!");
	}
	


}
