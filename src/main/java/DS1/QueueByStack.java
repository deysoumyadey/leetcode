package DS1;

import java.util.Stack;

public class QueueByStack {

	Stack<Integer> s1;
	Stack<Integer> s2;
	
    public QueueByStack() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        while(!s2.empty()) {
        	s1.push(s2.pop());
        }
        s1.push(x);
        
    }
    
    public int pop() {
        while(!s1.empty()) {
        	s2.push(s1.pop());
        }
        return s2.pop();
    }
    
    public int peek() {
    	while(!s1.empty()) {
        	s2.push(s1.pop());
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}
