package lab06;

public class InsertionSort<E extends Comparable<E>> {

    /** The constant in the formula t = c * O() */
    private double c;

    /** The order O() of the implementation.
        If your implementation is in O(n^2), use Math.pow().
	    @param n index
	    @return the function of n inside the O()
	 */
    public double O(int n) {
        
        return Math.pow(n, 2);
    }

    /** Calculates the constant c using a given input array of type E.
        Units of time should be converted to microseconds
    */
    public void fit(E[] array) {
        long startTime = System.nanoTime();
        sort(array);
        long stopTime = System.nanoTime();
        long totalTime = (stopTime - startTime) /1000;
        c = totalTime/(O(array.length));
    }

    /** Predicts the running time of an insertion sort for some index n
        @param n
        @return the estimated amount of time in unit microseconds
    */
    public double predict(int n) {
        
        return O(n)*c; 
    }

    /** Performs an insertion sort using a given input array
        @param array the (unsorted) array
        @return the sorted array
    */
    public E[] sort(E[] array) {

        /* Handle case where length of array is 1 or less */
    	if(array.length <= 1) {
    		//cannot be sorted
    		return array;
    	}

        /* make a copy of the array to sort */
        E[] sorted = array.clone();

        /* Perform the insertion sort */
        for(int i=1; i < sorted.length; i++)
        {
        	E index = sorted[i];
        	int j = i ;
            while(j>0 && sorted[j-1].compareTo(index) > -1) {
            	sorted[j] = sorted[j-1];
            	j--;
            	
            }
            sorted[j] = index;
            
        }

        return sorted; // not right
    }

}
