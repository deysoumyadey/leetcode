package TwoPointers;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Write a function that takes a string s as input and checks whether it’s a palindrome or not.
 */
public class ValidPalindrome {

    public boolean isValidPalindrome(String word) {
        int len = word.length();
        for(int i=0, j=len-1; i<j; i++, j--) {
            if(word.charAt(i) != word.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testIsValidPalindrome(){
        String testcase1 = "AABBAA";
        assertTrue(isValidPalindrome(testcase1));
        String testcase2 = "AABBAAc";
        assertFalse(isValidPalindrome(testcase2));
    }

}
