package EducativeIO.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

public class ReverseWord {
    public static String reverseWords(String sentence) {

        int leftStart=0, left = 0, rightEnd=sentence.length()-1, right=sentence.length()-1;
        while(left<right) {
            if(sentence.charAt(left)!=' ')
                left++;
            if(sentence.charAt(right)!=' ')
                right--;
            if(sentence.charAt(left)!=' ' && sentence.charAt(right)!=' ') {
                swapWords(sentence, leftStart, left, right, rightEnd);
            }
        }
        return sentence;
    }

    private static void swapWords(String sentence, int leftStart, int left, int right, int rightEnd) {
    }

    @Test
    public void testReverseWords() {
        Assert.assertEquals("world hello", reverseWords("hello world"));
    }
}
