package DS1;

import java.util.Stack;

public class ReverserLinkedList {
	public ListNode reverseList(ListNode head) {
		if(head == null) return null;
		Stack<Integer> stackInt = new Stack<Integer>();
		while(head!=null) {
			stackInt.push(head.val);
			head = head.next;
		}
		ListNode result = new ListNode(stackInt.pop());
		ListNode resultHead = result;
		while(!stackInt.empty()) {
			ListNode newNode = new ListNode(stackInt.pop());
			result.next = newNode;
			result = result.next;
		}
		return resultHead;
	}
	public ListNode reverseListRecursively(ListNode head, ListNode prev) {
		if(head != null)
			head.next = reverseListRecursively(head.next, head);
		return prev;
	}
	public ListNode reverseListRecursively2(ListNode head) {
		if(head==null) return null;
		if(head.next == null) return head;
		return reverseListRecursively(head.next, head);
	}
}
