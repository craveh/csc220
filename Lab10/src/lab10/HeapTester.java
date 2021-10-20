package lab10;

public class HeapTester {

    public static void main(String[] arg)
    {
        // ********************* TESTS FOR LAB ****************************//

         MaxHeap maxHeap = new MaxHeap(15);

         int[] arr1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
         if (!maxHeap.IsEqual(arr1))
            System.err.println("TEST FAILED: offer 0");
         //System.out.println(maxHeap);

         maxHeap.offer(5);
         //maxHeap.offer(17);

         int[] arr2 = {5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
         if (!maxHeap.IsEqual(arr2))
            System.err.println("TEST FAILED: offer 1");

         maxHeap.offer(3);

         int[] arr3 = {5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
         if (!maxHeap.IsEqual(arr3))
            System.err.println("TEST FAILED: offer 2");

         maxHeap.offer(17);

         int[] arr4 = {17, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
         if (!maxHeap.IsEqual(arr4))
            System.err.println("TEST FAILED: offer 3");

         maxHeap.offer(10);
         int[] arr5 = {17, 10, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
         if (!maxHeap.IsEqual(arr5))
            System.err.println("TEST FAILED: offer 4");

         maxHeap.offer(84);
         int[] arr6 = {84, 17, 5, 3, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
         if (!maxHeap.IsEqual(arr6))
            System.err.println("TEST FAILED: offer 5");

         maxHeap.offer(19);
         int[] arr7 = {84, 17, 19, 3, 10, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0};
         if (!maxHeap.IsEqual(arr7))
            System.err.println("TEST FAILED: offer 6");

         maxHeap.offer(6);
         int[] arr8 = {84, 17, 19, 3, 10, 5, 6, 0, 0, 0, 0, 0, 0, 0, 0};
         if (!maxHeap.IsEqual(arr8))
            System.err.println("TEST FAILED: offer 7");

         maxHeap.offer(22);
         int[] arr9 = {84, 22, 19, 17, 10, 5, 6, 3, 0, 0, 0, 0, 0, 0, 0};
         if (!maxHeap.IsEqual(arr9))
            System.err.println("TEST FAILED: offer 8");

         maxHeap.offer(9);
         int[] arr10 = {84, 22, 19, 17, 10, 5, 6, 3, 9, 0, 0, 0, 0, 0, 0};
         if (!maxHeap.IsEqual(arr10))
            System.err.println("TEST FAILED: offer 9");

         MaxHeap maxHeap1 = new MaxHeap(15);

         maxHeap1.offer(97);
         maxHeap1.offer(93);
         maxHeap1.offer(87);
         maxHeap1.offer(90);
         maxHeap1.offer(89);
         maxHeap1.offer(83);

         int[] arr11 = {97, 93, 87, 90, 89, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0};
         if (!maxHeap1.IsEqual(arr11))
            System.err.println("TEST FAILED: offer 10");
         System.out.println(maxHeap1);

         // poll tests
         System.out.println("testing poll");
         int maxVal1 = maxHeap1.poll();

         int[] arr12 = {93, 90, 87, 83, 89, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
         if (maxVal1 != 97 || !maxHeap1.IsEqual(arr12))
            System.err.println("TEST FAILED: poll 1");

         int maxVal2 = maxHeap1.poll();
         //System.out.println(maxVal2);

         int[] arr13 = {90, 89, 87, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
         if (maxVal2 != 93 || !maxHeap1.IsEqual(arr13))
            System.err.println("TEST FAILED: poll 2");

         MaxHeap maxHeap2 = new MaxHeap(15);
         if (maxHeap2.poll() != -1)
            System.err.println("TEST FAILED: poll 0");
           
         System.out.println("Testing Done (lab) !!!");


     // ********************* TESTS FOR ASSIGNMENT ****************************//
         System.out.println("Beginning Assignment Testing" + '\n' + '\n');

         int[] arr14 = {};
         MaxHeap maxHeap3 = new MaxHeap(arr14);

         if (!maxHeap3.IsEqual(arr14))
            System.err.println("TEST FAILED: constructor 0");

         int[] arr15 = {3};
         MaxHeap maxHeap4 = new MaxHeap(arr15);
         if (!maxHeap4.IsEqual(arr15))
            System.err.println("TEST FAILED: constructor 1");

         int[] arr16 = {22, 3};
         int[] arr16_2 = {3, 22};
         /*
         for(int i = 0; i<arr16_2.length; i++) {
        	 System.out.print(arr16_2[i] + " ");
         }
         System.out.println("test print");
         */
         MaxHeap maxHeap5 = new MaxHeap(arr16_2);
         /*
         for(int i = 0; i<arr16_2.length; i++) {
        	 System.out.print(arr16_2[i] + " ");
         }
         System.out.println("test print");
         
         for(int i = 0; i<arr16.length; i++) {
        	 System.out.print(arr16[i] + " ");
         }
         System.out.println("test print arr 16");
         */
         //System.out.println(maxHeap5);
         //System.out.println(maxHeap)
         if (!maxHeap5.IsEqual(arr16))
            System.err.println("TEST FAILED: constructor 2 test");
         //System.out.println("testing");
         /*
         for(int i = 0; i<arr16_2.length; i++) {
        	 System.out.print(arr16_2[i] + " ");
         }
         System.out.println("test print");
         */

         int[] arr17 = {84, 22, 19, 17, 10, 5, 6, 3, 9};
         int[] arr17_2 = {5, 3, 17, 10, 84, 19, 6, 22, 9};
         /*
         for(int i =0; i< arr17_2.length; i++) {
      		System.out.print(arr17_2[i] + "  ");
      	}
      	System.out.println("arr17_2");
      	*/
         MaxHeap maxHeap6 = new MaxHeap(arr17_2);
        /* 
         for(int i =0; i< arr17_2.length; i++) {
      		System.out.print(arr17_2[i] + "  ");
      	}
      	System.out.println("arr17_2");
      	
      	for(int i =0; i< arr17.length; i++) {
      		System.out.print(arr17[i] + "  ");
      	}
      	System.out.println("arr17");
      	*/

         if (!maxHeap6.IsEqual(arr17))
            System.err.println("TEST FAILED: constructor 3");
         /*
         for(int i =0; i< arr17.length; i++) {
       		System.out.print(arr17[i] + "  ");
       	}
       	System.out.println("arr17");
       	*/
        // System.out.println("testing");
         //System.out.println("testing sort method");
         /*
         for(int i =0; i< arr17_2.length; i++) {
      		System.out.print(arr17_2[i] + "  ");
      	}
      	System.out.println("arr17_2");
      	*/

         MaxHeap maxHeap7 = new MaxHeap(1);
         maxHeap7.sort(arr15);
         if (!maxHeap7.IsEqual(arr15))
            System.err.println("TEST FAILED: sort 1");
         //System.out.println("testing");
         

         MaxHeap maxHeap8 = new MaxHeap(2);
         maxHeap8.sort(arr16);
         //System.out.println(maxHeap8);
         int[] testArr = {3, 22};
         if (!maxHeap8.IsEqual(testArr))
             System.err.println("TEST FAILED: my own sort testing");
         
         
         //System.out.println("Sort 2 test  max heap 8  " + maxHeap8);
         /*
         for(int i = 0; i<arr16_2.length; i++) {
        	 System.out.print(arr16_2[i] + " ");
         }
         System.out.println("test print");
         */
         if (!maxHeap8.IsEqual(arr16_2))
            System.err.println("TEST FAILED: sort 2");
         //System.out.println("testing sort 2");
         /*
         for(int i =0; i< arr17_2.length; i++) {
     		System.out.print(arr17_2[i] + "  ");
     	}
     	System.out.println("arr17_2");
     	*/
         //System.out.println("start my test");
         MaxHeap testSort3 = new MaxHeap(9);
         int[] arrTestSort = {5, 3, 17, 10, 84, 19, 6, 22, 9};
         
         testSort3.sort(arrTestSort);

         //System.out.println("end of my test");
         

         MaxHeap maxHeap9 = new MaxHeap(9);
         maxHeap9.sort(arr17_2);
         int[] arr18 = {3, 5, 6, 9, 10, 17, 19, 22, 84};
         if (!maxHeap9.IsEqual(arr18))
            System.err.println("TEST FAILED: sort 3");

        System.out.println("Testing Done (assignment) !!!");


    }

}
