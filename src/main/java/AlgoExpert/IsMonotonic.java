package AlgoExpert;

public class IsMonotonic {
	public static boolean isMonotonic(int[] array) {
		if(array.length<3){
			return true;
		}
		int curr=1, prev=0;
		while(curr<array.length && array[curr]==array[prev] ) {
			curr++;
			prev++;
		}
		if(curr>=array.length)
			return true;
		int isInc = 0;
		if(array[prev]<array[curr]) {
			isInc = 1;
		} else if(array[prev]>array[curr]) {
			isInc = -1;
		} 
		
		for(int i=curr+1; i<array.length; i++) {
			if(isInc == 1 && array[i-1]>array[i])
				return false;
			else if (isInc == -1 && array[i-1]<array[i])
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		/*System.out.println(isMonotonic(new int[] {-1, -5, -10, -1100, -1100, -1101, -1102, -9001}));
		System.out.println(isMonotonic(new int[] {}));
		System.out.println(isMonotonic(new int[] {1}));
		System.out.println(isMonotonic(new int[] {1, 2}));
		System.out.println(isMonotonic(new int[] {2, 1}));
		System.out.println(isMonotonic(new int[] {1, 5, 10, 1100, 1101, 1102, 9001}));
		System.out.println(isMonotonic(new int[] {-1, -5, -10, -1100, -1101, -1102, -9001}));
		System.out.println(isMonotonic(new int[] {-1, -5, -10, -1100, -900, -1101, -1102, -9001}));
		System.out.println(isMonotonic(new int[] {1, 2, 0}));*/
		System.out.println(isMonotonic(new int[] {-1, -1, -1, -1, -1, -1, -1, -1}));/*
		System.out.println(isMonotonic(new int[] {-1, -1, -2, -3, -4, -5, -5, -5, -6, -7, -8, -7, -9, -10, -11}));
		System.out.println(isMonotonic(new int[] {-1, -1, -2, -3, -4, -5, -5, -5, -6, -7, -8, -8, -9, -10, -11}));
		System.out.println(isMonotonic(new int[] {-1, -1, -1, -1, -1, -1, -1, -1}));
		System.out.println(isMonotonic(new int[] {11, 2, -1, -2, -5}));
		System.out.println(isMonotonic(new int[] {-1, -5, 10}));*/
	}
}
