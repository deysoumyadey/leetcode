import java.util.Arrays;

public class SmallestNumInArray {
	// you can also use imports, for example:
	// import java.util.*;

	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");

	public int solution(int[] A) {
		// write your code in Java SE 8
		Arrays.sort(A);
		int missingMin = 0;
		for(int i=0; i<A.length; i++) {
			if(missingMin==A[i]) 
				missingMin++;
		}
		return missingMin;
	}
}
