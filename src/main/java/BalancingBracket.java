import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

import java.util.Stack;

// solution

class BalancingBracket {

    public static boolean validateSymbols(String str) {
        // fill in
        // with solution
    	String leftBrackets = "{([";
    	String rightBrackets = "})]";
    	Stack<Character> charStack = new Stack<Character>();
    	for(char c : str.toCharArray()) {
    		if(leftBrackets.contains(String.valueOf(c))){
    			charStack.push(c);
    		} else if(rightBrackets.contains(String.valueOf(c))) {
    			if(!charStack.isEmpty() && ((charStack.lastElement() == '{' && c=='}') || (charStack.lastElement() == '(' && c==')') || (charStack.lastElement() == '[' && c==']'))) {
    				charStack.pop();
    			} else {
    				return false;
    			}
    		}
    	}
        if(charStack.empty())
        	return true;
        else
        	return false;
    }

    // print your findings using this function!
    public static void log() {
        System.out.println(validateSymbols(""));
    }

}


public class MainTest {

    // tests

    @Test
    public void simpleSquareBracketsTest() {
        assertTrue(Solution.validateSymbols("[]"));
    }

    @Test
    public void curlyAndNestedSquareBracketsTest() {
        assertTrue(Solution.validateSymbols("{{[]}}"));
    }

    @Test
    public void invalidParenthesisTest() {
        assertFalse(Solution.validateSymbols("[[}}"));
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MainTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }

}
