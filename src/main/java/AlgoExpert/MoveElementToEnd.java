package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {
	public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
		List<Integer> result = new ArrayList<>();
		int len = array.size();
		for(int i=0; i<len; i++) {
			if(array.get(i).intValue()==toMove) {
				array.remove(i);
				array.add(toMove);
			}
		}
		return new ArrayList<Integer>();
	}
	
	public static List<Integer> moveElementToEnd2(List<Integer> array, int toMove) {
		int left=0, right = array.size()-1;
		while(left<right) {
			while(left<right && array.get(right)==toMove) right--;
			if(array.get(left)==toMove)	swap(left, right, array);
			left++;
		}
		return array;
	}

	private static void swap(int left, int right, List<Integer> array) {
		int temp = array.get(right);
		array.set(right, array.get(left));
		array.set(left, temp);
	}

	public static void main(String[] args) {
		List<Integer> a = moveElementToEnd2(Arrays.asList(2,1,2,2,2,3,3,4,2), 2);
		for(Integer a1: a) {
			System.out.println(a1);
		}
	}
}
