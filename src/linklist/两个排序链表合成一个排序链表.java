package linklist;

import support.ListNode;

public class 两个排序链表合成一个排序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null ) return l2;
        if(l2 == null) return l1;
    	if(l1.val < l2.val){
    		l1.next = mergeTwoLists(l1.next, l2);
    		return l1;
    	} else{
    		l2.next = mergeTwoLists(l1, l2.next);
    		return l2;
    	}
    }

}



/* 非递归
if(l1 == null ) return l2;
if(l2 == null) return l1;
ListNode pre = new ListNode(0);
ListNode head = pre;
while(l1 != null  && l2 != null) {
	if(l1.val <= l2.val) {
		pre.next = l1;
		l1 = l1.next;
	} else {
		pre.next = l2;
		l2 = l2.next;
	}
	pre = pre.next;
}
if(l1 == null) {
	pre.next = l2;
} else {
	pre.next = l1;
}
return head.next;*/
