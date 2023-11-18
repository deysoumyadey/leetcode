package AlgoExpert.Array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class NonConstructibleChanges {
    public int getNonConstructibleChanges(int[] coins) {
        int smallestPossibleChange = 0;
        Arrays.sort(coins);
        int sumAll = Arrays.stream(coins).sum();
        for(int j=1; j<sumAll; j++) {
            int left = 0, right = 0, sum = 0;
            while(left<coins.length || right>coins.length) {
                if(sum == j) {
                    break;
                } else if (sum < j) {
                    sum += coins[right];
                    right++;
                } else if (sum > j) {
                    sum -= coins[left];
                    if (sum == j)
                        break;
                    left++;
                }
            }
            if (j != sum) {
                smallestPossibleChange = j;
                break;
            }
        }
        return smallestPossibleChange;
    }

    @Test
    public void testGetNonConstructibleChanges() {
        //int[] coins = {1,2,5};
        //int expected = 4;

        int[] coins = {5, 7, 1, 1, 2, 3, 22}; // 1,1,2,3,5,7,22
        int expected = 20;
        int actual = getNonConstructibleChanges(coins);

        Assert.assertEquals(expected, actual);
    }
}
