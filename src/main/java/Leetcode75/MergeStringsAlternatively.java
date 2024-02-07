package Leetcode75;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1768
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
 * starting with word1. If a string is longer than the other,
 * append the additional letters onto the end of the merged string.
 *
 * Return the merged string.
 *
 * Example 1:
 *
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 * Example 2:
 *
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 * Example 3:
 *
 * Input: word1 = "abcd", word2 = "pq"
 * Output: "apbqcd"
 * Explanation: Notice that as word1 is longer, "cd" is appended to the end.
 * word1:  a   b   c   d
 * word2:    p   q
 * merged: a p b q c   d
 */
public class MergeStringsAlternatively {

    public String mergeAlternately(String word1, String word2) {
        int largerLen = Math.max(word1.length(), word2.length());
        StringBuilder output = new StringBuilder();
        for(int i=0; i<largerLen; i++) {
            if(i < word1.length() && i < word2.length()) {
                output.append(word1.charAt(i)).append(word2.charAt(i));
            }
            else if(i >= word1.length()) {
                output.append(word2.charAt(i));
            }
            else if(i >= word2.length()) {
                output.append(word1.charAt(i));
            }
        }
        return output.toString();
    }

    @Test
    public void testMergeAlternatively() {
        assert "apbqcr".equals(mergeAlternately("abc", "pqr"));
        assert "apbqrs".equals(mergeAlternately("ab", "pqrs"));
        assert "apbqcd".equals(mergeAlternately("abcd", "pq"));
    }
}
