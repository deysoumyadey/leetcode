

/**
 * 
 * @author soumya
 * Given an integer n, return true if it is a power of four. Otherwise, return false.
 * An integer n is a power of four, if there exists an integer x such that n == 4x.
 */
public class No342PowerOfFour {
	public static boolean isPowerOfFour(int n) {
		/*while(n>1) {
			if(n%4 != 0)
				break;
			n=n/4;
		}
		return n==1 ? true : false;*/
		
		return n>0 && (n & (n-1)) == 0 && (n-1)%3==0;
	}
	public static void main(String[] args) {
		System.out.println(isPowerOfFour(164));
	}
}
