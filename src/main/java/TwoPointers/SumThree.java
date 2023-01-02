package TwoPointers;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class SumThree {

    public boolean findSumOfThree(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<len; i++) {
            int lowIdx = i+1, highIdx = len-1;
            while(lowIdx<highIdx) {
                int sum = nums[i] + nums[lowIdx] + nums[highIdx];
                if (sum == target) {
                    return true;
                } else if (sum > target) {
                    highIdx--;
                } else {
                    lowIdx++;
                }
            }
        }
        return false;
    }

    @Test
    public void testFindSumOfThree() {
        int[] nums = { 1, 4, 45, 6, 10, 8 };
        int target = 22;
        assertTrue(findSumOfThree(nums, target));
    }
}
