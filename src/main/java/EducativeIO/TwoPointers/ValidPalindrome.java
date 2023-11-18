package EducativeIO.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left<right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    @Test
    public void testIsPalindrome() {
        Assert.assertTrue(isPalindrome("abcba"));
        Assert.assertTrue(isPalindrome("abccba"));
        Assert.assertFalse(isPalindrome("test"));
    }
}
