package TwoPointers;
/**
 * 26. Remove Duplicates from Sorted Array
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveDupSortedArr {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len==0) {
            return 0;
        } else if(len==1) {
            return 1;
        } else {
            int left = 0, right = 1;
            while (right < len) {
                if (nums[left] == nums[right]) {
                    right++;
                } else if (right - left > 1) {
                    left++;
                    nums[left] = nums[left] + nums[right];
                    nums[right] = nums[left] - nums[right];
                    nums[left] = nums[left] - nums[right];
                    right++;
                } else {
                    left++;
                    right++;
                }
            }
            return left+1;
        }
    }

    @Test
    public void testRemoveDupSortedArr() {
        assertEquals(3, removeDuplicates(new int[]{1, 2, 3}));
        assertEquals(2, removeDuplicates(new int[]{1, 2}));
        assertEquals(1, removeDuplicates(new int[]{1}));
        assertEquals(2, removeDuplicates(new int[]{1, 1, 3}));
        assertEquals(5, removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        assertEquals(3, removeDuplicates(new int[]{1, 2, 3}));
    }
}
