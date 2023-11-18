package EducativeIO.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SumThree {
    public static boolean findSumOfThree(int[] nums, int target) {

        Arrays.sort(nums);
        int len=nums.length-1;
        for(int i=0; i<len; i++) {
            int p1=1, p2=len;
            while (p1<p2 && p1 <= len && p2 > 0) {
                int sum = nums[i] + nums[p1] + nums[p2];
                if(sum == target) {
                    return true;
                }
                else if (sum > target) {
                    p2--;
                }
                else if (sum < target) {
                    p1++;
                }
            }
        }

        return false;
    }

    @Test
    public void testFindSumOfThree() {
        //Assert.assertTrue(findSumOfThree(new int[]{3,7,1,2,8,4,5}, 10)); //1,2,3,4,5,7,8
        Assert.assertFalse(findSumOfThree(new int[]{1, -1, 0}, -1)); // -1, 0, 1
    }
}
