package list;

import support.ListNode;

/**
 * https://leetcode.com/problems/partition-list/
 * 将链表中小于x的节点放在它前面
 * For example,
 * 1->4->3->2->5->2 and x = 3,
 */
public class 根据特定值x划分链表 {
    public ListNode partition(ListNode head, int x) {
    	if(head == null || head.next == null)
    		return head;
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        while(head != null) {
        	if(head.val < x) {
        		cur1.next = head;
        		cur1 = cur1.next;
        	} else {
        		cur2.next = head;
        		cur2 = cur2.next;
        	}
        	head = head.next;
        }
        // 必须有这一步,否则若cur2指向的不是原链表的最后一个节点,链表会成环
        cur2.next = null;
    	cur1.next = dummy2.next;
    	return dummy1.next;
    }
}
