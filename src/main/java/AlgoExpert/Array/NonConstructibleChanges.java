package AlgoExpert.Array;

import java.util.Arrays;

public class NonConstructibleChanges {
    public static int getNonConstructibleChanges(int[] coins) {
        int smallestPossibleChange = 0;
        Arrays.sort(coins);
        int totalSum = Arrays.stream(coins).sum();
        for (int i = 0; i < coins.length; i++) {
            int j = i;
            while(j>0){
                //coins[i];
                j--;
            }
        }
        return smallestPossibleChange;
    }
}
