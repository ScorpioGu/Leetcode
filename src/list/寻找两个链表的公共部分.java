package list;

import support.ListNode;
//寻找两个链表的交叉点
//		A:          a1 → a2
//							↘
//								c1 → c2 → c3
//							↗
//		B:     b1 → b2 → b3
public class 寻找两个链表的公共部分 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if(headA==null || headB==null) return null;  

    	//因为从交叉点之后，两个链表的长度时相同的为c.A链表之前的长度为a,B链表之前的长度是b。
		//所以，A链表遍历完之后紧接着B,B遍历完自身之后紧接着遍历A。两个指针每次都走一步，那么
		//走a+b+c步之后他两肯定会走到一起。
    	ListNode apre = headA;
    	ListNode bpre = headB;
    	while(apre != bpre) {
    		apre = (apre != null)?apre.next:headB;
    		bpre = (bpre != null)?bpre.next:headA;
    	}
    	return apre;
    }
}
