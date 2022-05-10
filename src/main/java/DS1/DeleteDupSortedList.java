package DS1;

public class DeleteDupSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        head.next = deleteDuplicates(head.next);
        return head.val==head.next.val ? head.next : head;
        
    }
    public static ListNode deleteDuplicateUtil(ListNode head, ListNode prev){
        if(head==null)
            return head;
        else if(prev.val == head.val){
            prev.next = head.next;
            head.next = deleteDuplicateUtil(head.next, prev);
        } else
            head.next = deleteDuplicateUtil(head.next, prev.next);
        return head;
    }
    public static void main(String[] args) {
    	ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(1);
    	ListNode l3 = new ListNode(2);
    	l1.next = l2;
    	l2.next = l3;
    	l3.next = null;
    	System.out.println(deleteDuplicates(l1).val);
    }
}
