package DS1;

public class MergeSortedLists {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode prevList1 = list1, prevList2 = list2, head1 = list1;
		int count = 0;
		if (list2 != null && list1 == null) {
			head1 = list2;
		} else {
			while (list1 != null && list2 != null) {
				if (list1.val == list2.val) {
					ListNode newListNode = new ListNode(list2.val);
					prevList1 = list1;
					prevList2 = list2;
					newListNode.next = list1.next;
					list1.next = newListNode;
					list1 = list1.next;
					list2 = list2.next;
				} else if (list1.val > list2.val) {
					ListNode newListNode = new ListNode(list2.val);
					newListNode.next = list1;
					prevList1.next = newListNode;
					prevList2 = list2;
					list2 = list2.next;
					if (count == 0)
						head1 = prevList2;
				} else {
					prevList1 = list1;
					list1 = list1.next;
				}
				count++;
			}
		}
		return head1;
	}
}
