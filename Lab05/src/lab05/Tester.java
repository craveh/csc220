package lab05;

public class Tester {
	public static void main(String[] args) {
		System.out.println(System.nanoTime());

/*		
		SortedBinarySet test1 = new SortedBinarySet();
//Check empty method		
		if(!test1.empty()) {
			System.err.println("TEST FAILED - empty() method");
		}
//Check toString()		
//		System.out.println(test1);
		
		test1.insert(36);
		//System.out.println(test1);
		test1.insert(23);
		//System.out.println(test1);
		test1.insert(17);
		//System.out.println(test1);
		test1.insert(49);
		test1.insert(73);
		test1.insert(5);

		test1.insert(3);
//Test a number already in array			
		boolean works = test1.insert(49);	
		if(works) {
			System.err.println("TEST FAILED- insert method number already in array");
		}
//Add up to size 11		
		test1.insert(5);
		test1.insert(3);
		test1.insert(7);
		test1.insert(92);
		test1.insert(99);
		test1.insert(100);

//Check if can add more:
		//test1.grow();
		//System.out.println(test1);
		
		test1.insert(66);
		//System.out.println(test1);
		
		//test1.clear();
		
		System.out.println(test1);
		
		/*if(!test1.empty()) {
			System.err.println("TEST FAILED - empty() method");
		}
		*/
/*	
//Test remove()
		if(test1.remove(30)) {
			System.err.println("Error in remove()");
		}
		if(test1.remove(5)) {
			//System.out.println(test1);
		}
		test1.remove(23);
		test1.remove(50);
		//System.out.println(test1);
		
// Add and remove stuff to check binaryFind() method		
		test1.insert(50);
		test1.remove(17);
		test1.insert(19);
		test1.insert(150);
		System.out.println("Binary find test");
		System.out.println(test1);
		
//Test contains() double method
		if(test1.contains(20)) {
			System.err.println("Have an error in conatins()");
		}
		//System.out.println(test1.contains(19));
		
//Test containsAll() array method
		SortedBinarySet test2 = new SortedBinarySet();
		test2.insert(3);
		test2.insert(19);
		double[] testing = new double[] {3, 19};
/*		
		double[] test2Array = test2.getArray();
		for(int i =0; i< test2Array.length; i++) {
			System.out.print(test2Array[i] + " ");
		}
*/
/*	
		System.out.println("Test2:" + "\n" + test2);
		
		System.out.println("test1 contains test2: " + test1.containsAll(test2.getArray()));		
		System.out.println("test1 contains test2: " + test1.containsAll(testing));
		
		test2.insert(29);
		System.out.println("test1 contains test2: " + test1.containsAll(test2.getArray()));

// Test constructor
		double[] input = new double[] {44, 43, 97, 13, 44};
		SortedBinarySet test3 = new SortedBinarySet(input);
		System.out.println(test3);
		test3.remove(44);
		test3.insert(12);
		System.out.println(test3);
*/		
		
//Test time between sequentialFind and binaryFind
		
		SortedBinarySet test4 = new SortedBinarySet();
		int number = 100025;
		while(number > 0) {
			test4.insert(number);
			number--;
		}
		System.out.println(System.nanoTime());
		
		
		System.out.println("Testing done");
	}
}
