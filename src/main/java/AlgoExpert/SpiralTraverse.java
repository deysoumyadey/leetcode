package AlgoExpert;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author soumya
 * testing 4th time
 */
public class SpiralTraverse {
	public static List<Integer> spiralTraverse(int[][] a) {
		int n = a.length, m = a[0].length;
		List<Integer> result = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int r=i; r<m-i; r++) {
				result.add(a[i][r]);
			}
			for(int d=i+1; d<n-i; d++) {
				result.add(a[d][m-i-1]);
			}
			for(int l=m-i-2; l>i; l--) {
				result.add(a[n-i-1][l]);
			}
			for(int u=n-i-1; u>=i+1; u--) {
				result.add(a[u][i]);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[][] a = new int[4][5];
		a[0][0] = 1;
		a[0][1] = 2;
		a[0][2] = 3;
		a[0][3] = 4;
		a[0][4] = 5;
		a[1][4] = 6;
		a[2][4] = 7;
		a[3][4] = 8;
		a[3][3] = 9;
		a[3][2] = 10;
		a[3][1] = 11;
		a[3][0] = 12;
		a[2][0] = 13;
		a[1][0] = 14;
		a[1][1] = 15;
		a[1][2] = 16;
		a[1][3] = 17;
		a[2][3] = 18;
		a[2][2] = 19;
		a[2][1] = 20;
		a[2][0] = 21;
		System.out.println(spiralTraverse(a));
	}
}
