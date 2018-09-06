package list;

import support.ListNode;
//未写博客
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if(head == null) return null;
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode pre = dummy;
    	ListNode cur = pre.next;
    	for(int i=0; i<n; i++) {
    		cur = cur.next;
    	}
    	while(cur != null) {
    		pre = pre.next;
    		cur = cur.next;
    	}
    	pre.next = pre.next.next;
    	return dummy.next;
     }
}
