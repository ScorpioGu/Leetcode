package linklist;

import support.ListNode;
//未写博客
public class 删除倒数第n个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if(head == null) return null;
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode pre = dummy;
    	ListNode cur = pre.next;
    	//让cur比pre先跑n个位置
    	for(int i=0; i<n; i++) {
    		cur = cur.next;
    	}
    	//然后两个两指针一起出发，让cur跑到头了，pre也跑到了被删除的节点的前一个节点的位置
    	while(cur != null) {
    		pre = pre.next;
    		cur = cur.next;
    	}
    	pre.next = pre.next.next;
    	return dummy.next;
     }
}
