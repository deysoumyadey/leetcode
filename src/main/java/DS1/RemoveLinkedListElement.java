package DS1;

public class RemoveLinkedListElement {
	public static ListNode removeElements(ListNode head, int val) {
		/*
		 * ListNode head1 = head; ListNode prev = head; if (head.val == val) { if
		 * (head.next != null) { prev = head.next; head = head.next; } else return null;
		 * }
		 * 
		 * while (head.next != null) { if(head.val == val) { prev.next = head.next; head
		 * = head.next; } } return head1;
		 */
		if(head == null)
			return null;
		head.next = removeElements(head.next, val);
		return head.val == val ? head.next : head;
	}
	
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(6);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = null;
		ListNode output = removeElements(node, 6);
		while(output!=null) {
			System.out.println(output.val);
			output = output.next;
		}
		
		
	}
}
