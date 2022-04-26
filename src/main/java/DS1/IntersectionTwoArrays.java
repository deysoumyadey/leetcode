package DS1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem: 350 Intersection of Two Arrays II
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
*/

public class IntersectionTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
    	List<Integer> ls = new ArrayList<Integer>();
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);
    	int i=0, j=0, k=0;
    	while(i<nums1.length && j<nums2.length) {
    		if(nums1[i]< nums2[j]) {
    			i++;
    		} else if(nums1[i]==nums2[j]) {
    			ls.add(nums1[i]);
    			i++;
    			j++;
    			k++;
    		} else {
    			j++;
    		}
    	}
    	int[] result = new int[k];
    	result = ls.stream().mapToInt(a -> a).toArray();
        return result;
    }
}
