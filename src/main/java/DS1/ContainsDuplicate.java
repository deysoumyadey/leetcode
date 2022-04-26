package DS1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        //Bruteforce
        /* for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] == nums[j])
                return true;
            }
        }
        return false;  */  
        //HashMap
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            numMap.put(nums[i], numMap.getOrDefault(nums[i],0)+1);
            if(numMap.get(nums[i])>1)
                return true;
        }
        return false;
        //HashSet
        /* Set<Integer> numSet = new HashSet<>();
        for(int num: nums){
            if(numSet.contains(num))
                return true;
            numSet.add(num);
        }
        return false; */
    }
    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        int[] a = {10,5,1,3,2};
        System.out.println(cd.containsDuplicate(a));
    }
}
