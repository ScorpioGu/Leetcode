package list;

import support.ListNode;
//未写博客

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
    	if(head == null || head.next == null) 
    		return head;
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int len = 0;
        while(fast.next != null) {
        	len++;
        	fast = fast.next;
        }
        
        for(int i=len-k%len; i>0; i--) {
        	slow = slow.next;
        }
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
        
    }
}
