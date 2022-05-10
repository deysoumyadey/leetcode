package toptal;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class question3 {
	public static int solution(int[] A) {

		int numberOfFilters = 0;
		int totalPollution = Arrays.stream(A).sum();
		double halfPollution = (double) (totalPollution / 2);

		long distinctPollution = Arrays.stream(A).distinct().count();
		if (distinctPollution == 1l)
			return A.length;

		PriorityQueue<Integer> pollutionQueue = new PriorityQueue<>(Collections.reverseOrder());
		for (int a : A)
			pollutionQueue.add(a);
		while (totalPollution > halfPollution) {
			int currentPollution = pollutionQueue.poll();
			double halfVal = (double) currentPollution / 2;
			totalPollution -= halfVal;
			numberOfFilters++;
			pollutionQueue.add((int) halfVal);

		}
		return numberOfFilters;

	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 5, 19, 8, 1 }));
		System.out.println(solution(new int[] { 3, 0, 5 }));
		System.out.println(solution(new int[] { 10, 10 }));
		System.out.println(solution(new int[] { 0 }));
		System.out.println(solution(new int[] {  }));
		System.out.println(solution(new int[] { 10, 10 }));
	}
}
