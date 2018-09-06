package support;


public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
    	if(head == null || head.next == null) return head;
    	ListNode pre = head;
    	ListNode cur = pre.next;
    	while(cur != null) {
    		ListNode temp = cur.next;
    		cur.next = pre;
    		pre = cur;
    		cur = temp;
    	}
    	head.next = null;
    	return pre;
    }
}
