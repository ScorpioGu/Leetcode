package list;
import support.ListNode;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) 
        	return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy.next;
        ListNode pre = dummy;
        while(cur != null ) {
        	while(cur.next != null && cur.val == cur.next.val) {
        		cur = cur.next;
        	}
        	if(pre.next == cur) {
        		pre = pre.next;
        		cur = cur.next;
        	} else {
        		pre.next = cur.next;
        		cur = cur.next;
        	}
        }
        return dummy.next;
    }
}
