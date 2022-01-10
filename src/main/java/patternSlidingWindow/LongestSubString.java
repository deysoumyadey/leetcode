package patternSlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */

public class LongestSubString {
    public static void main(String[] args){        
        System.out.println("Length of the longest SubString without repeating characters : " + LongestSubString.findLengthOfLongestSubString(" "));
        System.out.println("Length of the longest SubString without repeating characters : " + LongestSubString.findLengthOfLongestSubString("abcabcbb"));
        System.out.println("Length of the longest SubString without repeating characters : " + LongestSubString.findLengthOfLongestSubString("bbbbb"));
        System.out.println("Length of the longest SubString without repeating characters : " + LongestSubString.findLengthOfLongestSubString("pwwkew"));
    }

    private static int findLengthOfLongestSubString(String str) {
        int windowStart = 0, maxLength=0;
        Map<Character, Integer> charFrequency = new HashMap<Character, Integer>();
        for(int windowEnd=0; windowEnd<str.length(); windowEnd++){
            while(charFrequency.containsKey(str.charAt(windowEnd))){
                charFrequency.put(str.charAt(windowStart), charFrequency.get(str.charAt(windowStart))-1);                
                if(charFrequency.get(str.charAt(windowStart))==0)
                    charFrequency.remove(str.charAt(windowStart));
                windowStart++;
            }
            charFrequency.put(str.charAt(windowEnd), charFrequency.getOrDefault(str.charAt(windowEnd), 0)+1);
            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }
        return maxLength;
    }
}