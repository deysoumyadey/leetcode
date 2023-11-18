package TwoPointers;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Given a sentence, reverse the order of its words without affecting the order of letters within a given word.
 */
public class ReverseWords {
    public String reverseWords(String sentence){
        String[] sentenceArr = sentence.split("[ ]+");
        int len = sentenceArr.length;
        int lowerIdx = 0, higherIdx = len - 1;

        while(lowerIdx < higherIdx) {
            System.out.println(String.format("lowerIdx: {}, higherIdx: {}", sentenceArr[lowerIdx],
                    sentenceArr[higherIdx]));
            String temp = sentenceArr[lowerIdx];
            sentenceArr[lowerIdx] = sentenceArr[higherIdx];
            sentenceArr[higherIdx] = temp;
            lowerIdx++;
            higherIdx--;
        }
        return String.join(" ", sentenceArr);
    }

    @Test
    public void testReverseWords() {
        assertEquals("World Hello", reverseWords("Hello     World"));
        assertEquals("Java World Hello", reverseWords("Hello World Java"));
    }
}
