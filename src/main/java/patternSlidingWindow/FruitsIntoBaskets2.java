package patternSlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem Statement Given an array of characters where each character
 * represents a fruit tree, you are given two baskets and your goal is to put
 * maximum number of fruits in each basket. The only restriction is that each
 * basket can have only one type of fruit. You can start with any tree, but once
 * you have started you can’t skip a tree. You will pick one fruit from each
 * tree until you cannot, i.e., you will stop when you have to pick from a third
 * fruit type. Write a function to return the maximum number of fruits in both
 * the baskets. 
 * Example 1: Input: Fruit=['A', 'B', 'C', 'A', 'C'] Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C'] 
 * Example 2: Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C'] Output: 5 
 * Explanation: We can put 3 'B' in one basket and two 'C' in the other basket. This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
 */

public class FruitsIntoBaskets2 {
    public static void main(String[] args){
        System.out.println("Max number of fruits picked : " + FruitsIntoBaskets2.findMaxFruitsCollected(new char[] {'A', 'B', 'C', 'A', 'C'}));
        System.out.println("Max number of fruits picked : " + FruitsIntoBaskets2.findMaxFruitsCollected(new char[] {'A', 'B', 'C', 'B', 'B', 'D'}));
    }

	private static int findMaxFruitsCollected(char[] cs) {
        int windowStart=0, maxLength=0;
        Map<Character, Integer> distinct_fruit= new HashMap<Character, Integer>();
        for(int windowEnd=0; windowEnd<cs.length; windowEnd++){
           if(!distinct_fruit.containsKey(cs[windowEnd]))
               distinct_fruit.put(cs[windowEnd], 0);
            distinct_fruit.put(cs[windowEnd], distinct_fruit.get(cs[windowEnd])+1);
            while(distinct_fruit.size()>2){
                distinct_fruit.put(cs[windowStart],distinct_fruit.get(cs[windowStart])-1);
                if(distinct_fruit.get(cs[windowStart])==0)
                    distinct_fruit.remove(cs[windowStart]);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }
		return maxLength;
	}
}