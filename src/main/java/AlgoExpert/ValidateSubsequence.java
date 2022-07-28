package AlgoExpert;

import java.util.Arrays;
import java.util.List;

public class ValidateSubsequence {
	public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
		int i = 0;
		for (int j = 0; j < array.size(); j++) {
			if (array.get(j) == sequence.get(i)) {
				i++;
				if(i==sequence.size())
					break;
			}
		}

		if (i == sequence.size())
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isValidSubsequence(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10), Arrays.asList(22, 25, 6)));
	}
}
