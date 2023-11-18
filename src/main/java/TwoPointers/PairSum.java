package twoPointers;

/**
 * 
 * @author soumya
 * Given a sorted array and integer SUM.
 * Tell if any two elements in array can be added to get SUM
 */
public class PairSum {

	public static boolean isPairSum(int[] arr, int sum) {
		
		// Two pointer technique
		int i = 0;
		int j = arr.length-1;
		while(i<arr.length && j>0) {
			if(arr[i]+arr[j] < sum) {
				i++;
			}
			else if(arr[i] + arr[j] > sum) {
				j--;
			}
			else if(arr[i] + arr[j] == sum){
				return true;
			}
		}
		return false;
		
		//brute force
//		for(int i=0; i<arr.length; i++) {
//			for(int j=i+1; j<arr.length; j++) {
//				if(arr[i]+arr[j] == sum) {
//					return true;
//				}
//			}
//		}
//		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isPairSum(new int[] {1,3,4,5,6,7,8,9}, 100));
	}
}
