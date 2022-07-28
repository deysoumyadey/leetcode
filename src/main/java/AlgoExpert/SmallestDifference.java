package AlgoExpert;

import java.util.Arrays;

public class SmallestDifference {
	public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
		int minDiff = Integer.MAX_VALUE;
		int resultOne = 0, resultTwo = 0;
		for (int i = 0; i < arrayOne.length; i++) {
			for (int j = 0; j < arrayTwo.length; j++) {
				int currDiff = Math.abs(arrayTwo[j] - arrayOne[i]);
				if (currDiff < minDiff) {
					resultOne = arrayOne[i];
					resultTwo = arrayTwo[j];
					minDiff = currDiff;
				}
			}
		}
		return new int[] { resultOne, resultTwo };
	}
/*
 * -1,3, 5, 10, 20, 28
 * 15,17,26,134,135
 * 16,12,10,-5,-3,6,2,565
 * if a2-a1>0
 * 		if(a1<a2)
 * 			a1ind++
 * if a2-a1<0
 * 		if(a1>a2)
 * 			a2ind++;
 * if a2-a1==0
 * 	return a1, a2
 */
	public static int[] smallestDifference2(int[] arrayOne, int[] arrayTwo) {
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		int minDiff = Integer.MAX_VALUE;
		int resultOne = 0, resultTwo = 0;
		int a1Idx=0, a2Idx=0;
		while(a1Idx<arrayOne.length && a2Idx<arrayTwo.length) {
			int currDiff = Math.abs(arrayTwo[a2Idx]-arrayOne[a1Idx]);
			if(currDiff==0) {
				return new int[] {arrayOne[a1Idx], arrayTwo[a2Idx]};
			} else {
				if(currDiff<minDiff) {
					resultOne=arrayOne[a1Idx];
					resultTwo=arrayTwo[a2Idx];
					minDiff=currDiff;
				}
				if(arrayOne[a1Idx]<arrayTwo[a2Idx]) {
					a1Idx++;
				} else if(arrayOne[a1Idx]>arrayTwo[a2Idx]) {
					a2Idx++;
				}
			}
		}
		return new int[] { resultOne, resultTwo };
	}

	public static void main(String[] args) {
		int[] a = smallestDifference2(new int[] { -1, 5, 10, 20, 28, 3 }, new int[] { 26, 134, 135, 15, 17 });
		System.out.println(a[0] + " " + a[1]);
	}
}
