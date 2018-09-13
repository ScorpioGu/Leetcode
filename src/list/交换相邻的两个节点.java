package list;

import support.ListNode;

//Given 1->2->3->4, you should return the list as 2->1->4->3.
public class 交换相邻的两个节点 {
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
        	return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur1 = pre.next;
        ListNode cur2 = cur1.next;
        while(cur2 != null && cur1 != null) {
        	ListNode tmp = cur2.next;
        	pre.next = cur2;
        	cur2.next = cur1;
        	cur1.next = tmp;
            pre = cur1;
            cur1 = cur1.next;
            if(cur1 != null) {
            	cur2 = cur1.next;
            }
        }
        return dummy.next;
    } 
}
