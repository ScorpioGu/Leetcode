package list;

import support.ListNode;

//将链表中小于x的节点放在它前面
//For example,
//1->4->3->2->5->2 and x = 3,
//return 1->2->2->4->3->5 链表实际被分成了1->2->2 和4->3->5.就像快排一样，做一个局部的排序
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
        		cur1.next = new ListNode(head.val);
        		cur1 = cur1.next;
        	} else {
        		cur2.next = new ListNode(head.val);
        		cur2 = cur2.next;
        	}
        	head = head.next;
        }
    	cur1.next = dummy2.next;
    	return dummy1.next;
    }
}
