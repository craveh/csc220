package lab06;

import java.util.Arrays;

public class SortedString implements Comparable<SortedString> {

	private String unsorted;
	private String sorted;

	public SortedString(String unsorted) {
		this.unsorted = unsorted;
		char[] sortChar = unsorted.toLowerCase().toCharArray();
		Arrays.sort(sortChar);
		sorted = new String(sortChar);
		// EXERCISE
	}

	/** convenience function to convert string array to a SortedString array
	   @param strings input array of strings
	   @return the SortedString representation
	*/
	public static SortedString[] toSortedString(String[] strings) {
		SortedString[] out = new SortedString[strings.length];
		for (int i = 0; i < out.length; i++)
			out[i] = new SortedString(strings[i]);
		return out;
	}

	/* Return sorted version of string */
	public String getSorted() {
		return sorted;
	}

	/* Return original (i.e. unsorted) string */
	public String getUnsorted() {
		return unsorted;
	}

	@Override
	public String toString() {
		return unsorted + "/" + sorted;
	}

	public int compareTo(SortedString other){
		if(sorted.equals(other.getSorted())) {
			return 0;
		}else if(sorted.compareTo(other.getSorted()) > 0){
			return 1;	
		}else {
			return -1;
		}
		
	}
}
