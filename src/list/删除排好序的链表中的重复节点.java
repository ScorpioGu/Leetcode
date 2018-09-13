package list;
import support.ListNode;

public class 删除排好序的链表中的重复节点 {
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
        	//此时cur停在最后一个重复的元素
        	if(pre.next == cur) {
        		//没有遇到重复的元素，pre,cur都往后移动即可
        		pre = pre.next;
        		cur = cur.next;
        	} else {
        		//遇到重复的元素了，cur现在所在的位置就是重复的元素，
        		pre.next = cur.next;
        		cur = cur.next;
        	}
        }
        return dummy.next;
    }
}
