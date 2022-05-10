package toptal;

import java.util.Arrays;
import java.util.Collections;

//Added 
public class question1 {
	public static int solution(int[] P, int[] S) {
		if(P.length!=S.length || !(P.length>1 && P.length<=100000) || !(S.length>1 && S.length<=100000))
			return 0;
        int numberOfPeople = Arrays.stream(P).sum();		
		for (int i = 0; i < S.length; i++) {   
            for (int j = i+1; j < S.length; j++) {   
               if(S[i] < S[j]) {  
                   int temp = S[i];  
                   S[i] = S[j];  
                   S[j] = temp;  
               }   
            }   
        }
		int carIndex=0;
		while (numberOfPeople > 0) {
			numberOfPeople -= S[carIndex];
			carIndex += 1;
		}
		return carIndex;
    }
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,4,1}, new int[] {1,5,1}));
		System.out.println(solution(new int[] {4,4,2,4}, new int[] {5,5,2,5}));
		System.out.println(solution(new int[] {2,3,4,2}, new int[] {2,5,7,2}));
		System.out.println(solution(new int[] {}, new int[] {}));
		System.out.println(solution(new int[] {1,4}, new int[] {1,5,1}));
		System.out.println(solution(new int[] {1,4,1}, new int[] {1,5,1}));
	}
}
