package DS1;

import java.util.HashSet;
import java.util.Set;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class LinkedListHasCycle {
	public boolean hasCycle(ListNode head) {
		Set<ListNode> nodeMemory = new HashSet<>();
		while (head != null) {
			if (nodeMemory.contains(head)) {
				return true;
			}
			nodeMemory.add(head);
			head = head.next;
		}
		return false;
	}
	/**
	 * Floyd's Cycle-Finding Algorithm
	 */
	public boolean hasCycle2(ListNode head) {
		ListNode slow_p = head, fast_p = head;
		int flag = 0;
		while (slow_p != null && fast_p != null && fast_p.next != null) {
			slow_p = slow_p.next;
			fast_p = fast_p.next.next;
			if(slow_p == fast_p) {
				flag = 1;
				break;
			}
		}
		if(flag==1)
			return true;
		else
			return false;
	}
}
