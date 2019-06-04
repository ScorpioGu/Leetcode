package linklist;

import support.ListNode;

//Input: 1->2->3->4->5->NULL, k = 2
//Output: 4->5->1->2->3->NULL,k有可能比链表的长度要大，就是循环，取余
public class 旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
    	if(head == null || head.next == null) 
    		return head;
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int len = 0;
        //要先知道链表的长度，为了定位slow，而且k可以大于链表长度，取余要用到
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
