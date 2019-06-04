package linklist;
import support.ListNode;


public class 删除排好序的链表中多余的重复元素 {
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
