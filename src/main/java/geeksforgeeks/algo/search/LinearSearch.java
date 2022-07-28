package geeksforgeeks.algo.search;

public class LinearSearch {

	public int findByLinearSearch(int[] input, int k) {
		for(int i=0; i<input.length; i++) {
			if(input[i]==k)
				return i;
		}
		return -1;
	}
}
