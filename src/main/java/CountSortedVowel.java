
public class CountSortedVowel {
	public static int countVowelStrings(int n) {
		if(n==1)
			return 5;
		else if(n<1)
			return 0;
		int[] sum = new int[] { 1, 1, 1, 1, 1 };
		int totalSum = 0;
		for (int i = 2; i <= n; i++) {
			int[] temp = new int[5];
			int a = 0;
			if(i!=2) {
				temp[0]=totalSum;
				a++;
			}
			for (; a < 5; a++) {
				
				int currSum = 0;
				for (int b = a; b < 5; b++) {
					currSum += sum[b];
				}
				temp[a] = currSum;
				totalSum += currSum;
			}
			sum = temp;
		}
		return totalSum;
	}
	
	public static int countVowelStrings2(int n) {
		int a=1, e=1, i=1, o=1, u=1;
		while(n-- > 1) {
			a = a+e+i+o+u;
			e = e+i+o+u;
			i = i+o+u;
			o = o+u;
			u = u;
		}
		return a+e+i+o+u;
	}
	public static void main(String[] args) {
		System.out.println(countVowelStrings2(3));
	}
}
