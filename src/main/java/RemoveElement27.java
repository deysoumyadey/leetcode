import org.junit.Test;

import static java.util.Arrays.sort;

public class RemoveElement27 {
    public int removeElement(int[] nums, int val) {
        if (nums.length > 0) {
            int lastIdx = nums.length - 1;
            for (int i = 0; i < nums.length && lastIdx > i; i++) {
                if (val == nums[i]) {
                    while (val == nums[lastIdx] && lastIdx > i) {
                        lastIdx--;
                    }
                    if (lastIdx > i) {
                        nums[i] += nums[lastIdx];
                        nums[lastIdx] = nums[i] - nums[lastIdx];
                        nums[i] = nums[i] - nums[lastIdx];
                    }
                }
            }
            int i = 0;
            while (i<nums.length && val != nums[i]) {
                i++;
            }
            return i;
        }
        else
            return 0;
    }

    @Test
    public void testRemoveElement() {
        int[] nums = {3,2,2,3};
        int val = 3;
        int[] expectedNums = {2,2}; // The expected answer with correct length.
        // It is sorted with no values equaling val.

        int k = removeElement(nums, val); // Calls your implementation

        assert k == expectedNums.length;
        sort(nums, 0, k); // Sort the first k elements of nums
        for (int i = 0; i < expectedNums.length; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
}
