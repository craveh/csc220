package lab05;

public class SortedBinarySet {
	/** represent the simple array that holds the list values */
	public double[] theData;
	/** holds the length of the storage array */
	private int capacity;
	/** holds the number of elements in the list */
	private int size;

	/** constant for initial storage array capacity */
	private static final int INITIAL_STORAGE_CAPACITY = 11;

	/** keep this FALSE for lab; we will play with this in the assignment **/
	public boolean usesBinarySearch = true; //Using binary search is faster

	/** default constructor */
	public SortedBinarySet(){
		
		// TODO
		theData =  new double[INITIAL_STORAGE_CAPACITY];
		capacity = theData.length;
		size = 0;
	}

	public SortedBinarySet(double[] input){
		this();
		for(int i =0; i<input.length; i++) {
			insert(input[i]);
		}
	}

	public boolean empty(){
		// TODO
		if(size==0) {
			return true;
		}else {
			return false; 
		}
		
	}

	public int size(){
		// TODO
		return size; //placeholder
	}

	public void grow(){
		capacity = 2*capacity;
		double[] doubleSize = new double[capacity];
		
		for(int i = 0; i<size; i++) {
			doubleSize[i]= theData[i];
		}
		theData = doubleSize;
	}

	public String toString(){
		String capacityInfo = "Capactity: "  + capacity;
		String sizeInfo = "Size: " + size;
		String contains = "";
		
		for(int i= 0; i<size; i++) {
			contains += theData[i];
			contains+= "   ";
		}
		// TODO
		return ("\n" + capacityInfo + "\n" + sizeInfo + "\n" + contains + "\n"); // placeholder
	}

	public void clear() {
		// TODO
		theData = new double[capacity];
		size = 0;
	}

	public boolean insert(double newVal){
		// TODO
		if (size == capacity) {
			grow();
		}
		
		int checkThere= findIndex(newVal);
		//System.out.println(checkThere + " " + newVal);
		
		if(checkThere >= 0) {
			return false;
		}else{
			checkThere = Math.abs(checkThere + 1);
			
			//System.out.println("CheckThere = "+checkThere);
			
			for(int i = size-1; i>=checkThere; i--) {
				//System.out.println(theData[size+1] + " " + theData[size]);
				theData[i+1] = theData[i];
			}
			theData[checkThere] = newVal;
			size += 1;
			return true;
		}
	
	}

	public boolean remove(double element){
		int location = findIndex(element);
		if(location < 0) {
			return false;
		}else {
			for(int i = location; i<size; i++) {
				//System.out.println(theData[size+1] + " " + theData[size]);
				theData[i] = theData[i+1];
				
			}
			
			size -= 1;
			return true;
		}
		
	}

	private int sequentialFind(double target) {
		// TODO
		for(int index =0; index<size; index++) {
			if(target == theData[index]) {
				return index;
			}else if(target < theData[index]) {
				return( -index -1);
			}
		}
		return (-size - 1); //placeholder
	}

	private int binaryFind(double target) {

		int min = 0;
		int max = size-1;
		int mid = 0;
		while(min<=max) {
			mid = (min+max)/2;
			if(theData[mid] == target) {
				return mid;
			}else if(theData[mid] < target) {
				min = mid + 1;
			}else {
				max = mid -1;
			}
				
		}
		return((-min) -1); // placeholder
	}

	public int findIndex(double target) {
		if (usesBinarySearch) {
			return binaryFind(target);
		} else {
			return sequentialFind(target);

		}
	}

	public boolean containsAll(double[] elements){
		for(int i = 0; i< elements.length; i++) {
			if(!contains(elements[i])) {
				return false;
			}
		}
		return true; // placeholder
	}

	public boolean contains(double element){
		int location = findIndex(element);
		if (location < 0) {
			return false;
		}else {
			return true;
		}

	}
//returns a double array that just contains the elements of theData (no zeros)	
	public double[] getArray() {
		double[] elemArray = new double[size];
		for(int i = 0; i<size; i++) {
			elemArray[i] = theData[i];
		}
		return elemArray;
	}

}
