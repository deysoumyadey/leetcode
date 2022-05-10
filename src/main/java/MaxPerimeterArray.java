import java.util.*;

public class MaxPerimeterArray {
	public static void main(String[] args) {
		// Assume a list of lists (matrix)
		Integer[][] raw = { { 1, 4, 3, 8, 0, 7 }, { 0, 9, 4, 3, 6, 1 }, { 7, 6, 5, 2, 4, 1 }, { 5, 4, 3, 8, 0, 7 },
				{ 1, 2, 0, 3, 1, 1 }, { 0, 6, 0, 2, 4, 1 } };
		List<List<Integer>> matrix = Helper.fromArray(raw);
		System.out.print(Helper.printMatrix(matrix));

		System.out.println("0: Expecting result: 0. Received " + findLargestPerimeter(0, matrix).toString());
		System.out.println("1: Expecting result: 9. Received " + findLargestPerimeter(1, matrix).toString());
		System.out.println("2: Expecting result: 24. Received " + findLargestPerimeter(2, matrix).toString());
		System.out.println("3: Expecting result: 40. Received " + findLargestPerimeter(3, matrix).toString());
		System.out.println("4: Expecting result: 55. Received " + findLargestPerimeter(4, matrix).toString());
		System.out.println("5: Expecting result: 57. Received " + findLargestPerimeter(5, matrix).toString());
		System.out.println("6: Expecting result: 59. Received " + findLargestPerimeter(6, matrix).toString());

	}

	// Write a function that will find the maximum perimiter sum
	// of a submatrix of matrix "m" with a given size "size".
	//
	// example m =
	// . 1,4,3
	// . 0,9,4
	// 7,6,5
	//
	// f(0, m) = 0 (size 0 submatrix always has max perimiter sum of 0)
	// f(1, m) = 9
	// f(2, m) = 9+4+6+5 = 24
	// f(3, m) = 1+4+3+4+5+6+7+0 = 30
	//
	// Creating helper function(s) is allowed and encouraged
	/*public static Integer findLargestSubmatrixPerimeterSum(Integer size, List<List<Integer>> m) {
		List<Integer> maxSum = new ArrayList<>();
		if (size == 0)
			return 0;
		else if (size == 1) {
			for (int i = 0; i < m.size(); i++) {
				for (int j = 0; j < m.get(i).size(); j++) {
					maxSum.add(m.get(i).get(j));
				}
			}
		}
		Integer sum = 0;
		for (int i = 0; i < m.size(); i++) {
			for (int j = 0; j < m.get(i).size(); j++) {
				for (int a = i; a <= size; a++) {
					for (int b = j; b <= size; b++) {
						// edges
						if (i == a || j == b || a == size || b == size) {
							sum += m.get(a).get(b);
						}
						// corners
//            if((a==i && b==j) || (a==i && b==size) || (a==size && b==j) || (a==size && b==size)){
//              sum-=m.get(a).get(b);
//            }
					}
				}
				maxSum.add(sum);
				sum = 0;
			}
		}
		int maximumSum = 0;
		for (int i = 0; i < maxSum.size(); i++) {
			maximumSum = Math.max(maximumSum, maxSum.get(i));
		}
		return maximumSum;
	}*/

	public static Integer findLargestPerimeter(Integer size, List<List<Integer>> m) {
		if(size==0)
			return size;
		int maxSum = 0;
		for (int i = 0; i <= m.size() - size; i++) {
			for (int j = 0; j <= m.size() - size; j++) {
				int left = 0;
				int down = 0;
				int right = 0;
				int up = 0;
				int currSum = 0;
				for (int k = 0; k < size; k++) {
					left += m.get(i).get(j + k);
					down += m.get(i + k).get(j + size - 1);
					right += m.get(i + size - 1).get(j + k);
					up += m.get(i + k).get(j);
				}
				if(size>1) {
					left -= m.get(i).get(j);
				}
				down -= m.get(i).get(j + size - 1);
				right -= m.get(i + size - 1).get(j + size - 1);
				up -= m.get(i + size - 1).get(j);
				currSum = left + down + right + up;
//				System.out.println("left: " + left);
//				System.out.println("down: " + down);
//				System.out.println("right: " + right);
//				System.out.println("up: " + up);
//				System.out.println("currSum: " + currSum);
				maxSum = Math.max(maxSum, currSum);
			}
		}
/*
		List<List<Integer>> leftArr = new ArrayList<>();
		List<List<Integer>> downArr = new ArrayList<>();
		for (int i = 0; i < m.size(); i++) {
			List<Integer> tempArr = new ArrayList<>();
			int sum = 0;
			for (int j = 0; j < m.get(i).size(); j++) {
				sum += m.get(i).get(j);
				tempArr.add(sum);
			}
			leftArr.add(i, tempArr);
		}

		for (int i = 0; i < m.size(); i++) {
			List<Integer> tempArr = new ArrayList<>();
			int sum = 0;
			for (int j = 0; j < m.get(i).size(); j++) {
				sum += m.get(j).get(i);
				tempArr.add(sum);
			}
			downArr.add(i, tempArr);
		}
		System.out.println("Printing sub arrays");
		System.out.println(Helper.printMatrix(leftArr));
		System.out.println(Helper.printMatrix(downArr));
		int maxSum = 0;
		for (int i = 0; i < m.size() - size; i++) {
			for (int j = 0; j < m.size() - size; j++) {
				int currSum = leftArr.get(i).get(j + size);
				currSum += leftArr.get(i + size).get(j + size);
				currSum += downArr.get(i).get(j + size);
				currSum += downArr.get(i + size).get(j + size);
				if (i > 0 || j > 0) {
					currSum -= leftArr.get(i).get(j - 1);
					currSum -= leftArr.get(i + size).get(j - 1);
					currSum -= downArr.get(j - 1).get(i);
					currSum -= downArr.get(j - 1).get(i + size);
				}
				currSum -= m.get(i).get(j);
				currSum -= m.get(i).get(j + size);
				currSum -= m.get(i + size).get(j);
				currSum -= m.get(i + size).get(j + size);
				maxSum = Math.max(maxSum, currSum);

			}
		}*/
		 
		return maxSum;

	}
}