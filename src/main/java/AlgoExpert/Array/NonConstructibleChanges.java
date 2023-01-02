package AlgoExpert.Array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class NonConstructibleChanges {
    public int getNonConstructibleChanges(int[] coins) {
        int smallestPossibleChange = 0;
        Arrays.sort(coins);
        int totalSum = Arrays.stream(coins).sum();
        for (int i = 0; i < coins.length; i++) {
            for (int j=i+1; j<coins.length; j++) {
                //sum =
            }
        }
        return smallestPossibleChange;
    }

    @Test
    public void testGetNonConstructibleChanges() {
        int[] coins = {1,2,5};
        int expected = 4;
        int actual = getNonConstructibleChanges(coins);

        Assert.assertEquals(expected, actual);
    }
}
