package AlgoExpert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum {

	//O(n^2), space: O(1)
	public static int[] twoNumberSum1(int[] array, int targetSum) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] + array[j] == targetSum)
					return new int[] { array[i], array[j] };
			}
		}

		return new int[0];
	}
	
	//O(n), space: O(n)
	public static int[] twoNumberSum2(int[] array, int targetSum) {
		Map<Integer, Integer> complementMap = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			if (complementMap.containsKey(array[i]) && complementMap.get(array[i]) + array[i] == targetSum)
				return new int[] { array[i], targetSum - array[i] };
			complementMap.put(targetSum - array[i], array[i]);
		}
		return new int[0];
	}

	//O(nlogn), space: O(1)
	public static int[] twoNumberSum3(int[] array, int targetSum) {
		Arrays.sort(array);
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			int currentSum = array[left] + array[right];
			if (currentSum == targetSum)
				return new int[] { array[left], array[right] };
			else if (currentSum < targetSum)
				left++;
			else
				right--;
		}
		return new int[0];
	}

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			System.out.println(twoNumberSum3(new int[] { 1, 3, 5, 7 }, 10)[i]);
		}
	}
}
