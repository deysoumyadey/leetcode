package TwoPointers;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Write a function that takes a string as input and checks whether it can be a valid palindrome
 * by removing at most one character from it.
 */
public class ValidPalindrome2 {
    public boolean isValidPalindrome2(String s) {
        int len = s.length()-1;
        int left = 0, right=len, count = 0;
        while(left<right) {
            if(s.charAt(left) != s.charAt(right) && count > 0) {
                return false;
            } else if (s.charAt(left) != s.charAt(right) && count == 0){
                count++;
                if(s.charAt(left) == s.charAt(right-1)) {
                    right-=2;
                    left++;
                } else if(s.charAt(left+1) == s.charAt(right)) {
                    left+=2;
                    right--;
                } else {
                    return false;
                }
            } else {
                right--;
                left++;
            }
        }
        return true;
    }

    @Test
    public void testValidPalindrome2() {
        assertTrue(isValidPalindrome2("madame"));
        assertTrue(isValidPalindrome2("dead"));
        assertTrue(isValidPalindrome2("abca"));
        assertFalse(isValidPalindrome2("tebbem"));
        assertFalse(isValidPalindrome2("eeccccbebaeeabebccceea"));
        assertFalse(isValidPalindrome2(
                "ognfjhgbjhzkqhzadmgqbwqsktzqwjexqvzjsopolnmvnymbbzoofzbbmynvmnloposjzvqxejwqztksqwbqgmdazhqkzhjbghjfno"));

    }
}
