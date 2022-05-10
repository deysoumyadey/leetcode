package DS1;

import java.util.LinkedList;
import java.util.Queue;

public class StackByQueue  {

	Queue<Integer> q1;
	Queue<Integer> q2;
    public StackByQueue() {
    	q1 = new LinkedList<>();
    	q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
    	int x = 0;
    	while(!q1.isEmpty()) {
    		x++;
    		q2.add(q1.poll());
    	}
    	while(!q2.isEmpty()) {
    		if(--x>0)
    			q1.add(q2.poll());
    		else
    			break;
    	}
    	return q2.poll();
    }
    
    public int top() {
    	int x = 0, y=0;
    	while(!q1.isEmpty()) {
    		x++;
    		q2.add(q1.poll());
    	}
    	while(!q2.isEmpty()) {
    		if(--x>0)
    			q1.add(q2.poll());
    		else {
    			y = q2.peek();
    			q1.add(q2.poll());
    		}
    		
    	}
    	return y==0?null:y;
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
    
    public static void main(String[] args) {
    	StackByQueue s1 = new StackByQueue();
    	s1.push(1);
    	s1.push(2);
    	System.out.println(s1.pop());
    	System.out.println(s1.top());
    	String name = "baeldung";
    	name = "adsfadsf";
    	String newName = name.replace("dung", "----");
    	System.out.println(name);
    	System.out.println(newName);
    	System.out.println(name.replace("dung", "----"));
    	System.out.println(0016);
    }
}