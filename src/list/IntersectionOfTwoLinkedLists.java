package list;

import support.ListNode;

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if(headA==null || headB==null) return null;  
//    	int alength = 0, blength = 0;
//    	ListNode apre = headA;
//    	ListNode bpre = headB;
//    	ListNode rtn = null;
//        while(apre != null) {
//        	alength++;
//        	apre = apre.next;
//        }
//        while(bpre != null) {
//        	alength++;
//        	bpre = bpre.next;
//        }
//        
//        if(alength > blength) {
//        	for(int i=0; i<alength-blength; i++) {
//        		headA = headA.next;
//        	}
//        } else {
//        	for(int i=0; i<blength-alength; i++) {
//        		headB= headB.next;
//        	}
//        }
//        
//        while(headA != null && headB != null) {
//        	if((headA.val == headB.val) {
//        		rtn = headA;
//        	} 
//        	headA = headA.next;
//        	headB = headB.next;
//        }
//        return rtn;
    	ListNode apre = headA;
    	ListNode bpre = headB;
    	while(apre != bpre) {
    		apre = (apre != null)?apre.next:headB;
    		bpre = (bpre != null)?bpre.next:headA;
    	}
    	return apre;
    }
}
