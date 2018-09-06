package list;
import support.ListNode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode pre = dummy.next;
    	ListNode cur = pre.next;
    	while(cur != null) {
    		if(pre.val == cur.val) {
    			pre.next = cur.next;
    		} else {
    			pre = cur;
    		}
			cur = cur.next;
    	}
    	return dummy.next;
    }
}
