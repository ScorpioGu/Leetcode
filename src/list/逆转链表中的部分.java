package list;

import support.ListNode;

//不会就画画图比划一下就出来了
public class 逆转链表中的部分 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if(head == null) 
    		return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        //pre移动到m-1个节点出，之后pre保持不变
        for(int i=0; i<m-1; i++) {
        	pre = pre.next;
        }
        //每次for循环之后，start在第i个位置，then在第i+1个位置。
        ListNode start = pre.next;
        ListNode then = start.next;
        for(int i=0; i<n-m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dummy.next;
    }
}
