package lab08;


// modified version of Chapter 16 LinkedIntList class (page 990)
public class LinkedIntList {
	public ListNode front; // first value in the list

	// post: constructs an empty list
	public LinkedIntList(){
		front = null;
	}

	public LinkedIntList(int[] arr){
		this();

		for (int i = 0; i < arr.length; i++)
			add(arr[i]);
	}

	// post: returns the current number of elements in the lists
	public int size(){
		int count = 0;
		ListNode current = front;
		while (current != null){
			current = current.next;
			count++;
		}
		return count;
	}

	// post: return comma-separated, bracketed version of the list
	public String toString(){
		if (front == null){
			return "[]";
		}else{
			String result = "[" + front.data;
			ListNode current = front.next;
			while (current != null){
				result += ", " + current.data;
				current = current.next;
			}
			result += "]";
			return result;
		}
	}

	// post: appends the given value to the end of the list
	public void add(int value){
		if (front == null){
			front = new ListNode(value);
		}else{
			ListNode current = front;
			while(current.next != null){
				current = current.next;
			}
			current.next = new ListNode(value);
		}
	}


	// pre: 0 <= index < size()
	// post: returns a reference to the node at the given index
	private ListNode nodeAt(int index){
		ListNode current = front;
		for (int i = 0; i < index; i++){
			current = current.next;
		}
		return current;
	}

	// pre: 0 <= index <= size()
	// post: inserts the given value at the given index
	public void add(int index, int value){
		if (index == 0){
			front = new ListNode(value, front);
		}else if (index == size()){
			add(value);
		}else if (index > size()){
			return;
		}else{
			ListNode current = nodeAt(index-1);
			current.next = new ListNode(value, current.next);
		}
	}

	//*************************************************

	// This method accepts an integer value as a parameter and returns the index in the list of
	// the last occurrence of that value, or -1 if the value is not found in the list.
	public int lastIndexOf(int value){
		if (front == null) {
			return -1;
		}
		ListNode current = front;
		int counter = 0;
		int index = -1;
		while(current != null) {
			
			if(current.data == value) {
				index = counter;
			}
			counter++;
			current = current.next;
		}
		if (index != -1) {
			return index;
		}
		else {
			return -1;
		}
	}

	// This method should remove all occurrence of a particular value.
	public void removeAll(int value){
		if(front == null) {
			return;
		}
		ListNode current = front;
		ListNode prev = null;
		//Checks if front has the value
		if(current.data == value) {
			front = current.next;
			current.next = null;
			current = front;
		}
		
		
		prev = current;
		// Checks the data from after front until the second to last node
		while(current!=null && current.next!= null) {
			
			if(current.data == value) {
				prev.next = current.next;
				current.next =  null;
				current = prev.next;
				//System.out.println(this + "  In method");
				
			}
			else{
				prev = current;
				current = current.next;
				
			}
		// while loop does not check last one
			if(current!=null && current.data == value) {
				prev.next = null;
			}
			
			
		}
		
	}

	// This method will rearrange the elements of a list of integers by moving to the end of the list all
	// values that are in odd-numbered positions and otherwise preserving list order. Remember, it does not
	// matter whether the value itself is odd or even; what matters is whether the value appears in an odd
	// index. Also, the original order of the elements of the list should otherwise be preserved.
	// You may not construct any new nodes nor use any auxiliary data structures to solve this problem.
	// You also may not change any data fields of the nodes; you must solve this problem by rearranging the
	// links of the list.
	public void shift(){
		if (front == null) {
			return;
		} 
		ListNode currentNode = front;
		
		int size = size();
		//System.out.println(size + "size");
		ListNode endNode = nodeAt(size - 1);
		//System.out.println(endNode.data);
		ListNode prev = null;
		int counter = 0;
		while(counter < size && currentNode.next != null) {
			//System.out.println(counter);
			
			if (counter % 2 == 0) {
				prev = currentNode;
				currentNode = currentNode.next;	
			}else{
				//System.out.println(this);
				prev.next = currentNode.next;
				//System.out.println(this);
				//System.out.println(currentNode.data);
				currentNode.next = null;
				endNode.next = currentNode;
				//System.out.println(this);
				currentNode = prev.next;
				endNode = endNode.next;
				
				
			}
		 counter++;	
		}
		
	}

	// This method will double the size of the list by replacing every integer
	// in the list with two of that integer.
	// if the list is empty simply return
	public void stutter(){
		if (front == null) {
			return;
		}
		
		ListNode currentNode = front;
		while(currentNode != null) {
			currentNode.next  = new ListNode(currentNode.data, currentNode.next);
			currentNode = currentNode.next.next;
		}
	}


}
