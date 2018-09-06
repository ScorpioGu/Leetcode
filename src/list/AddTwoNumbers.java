package list;


import support.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         if(l1 == null) return l2;
         if(l2 == null) return l1;
         ListNode a1 = l1;
         ListNode a2 = l2;
         ListNode dummy = new ListNode(0);
         ListNode cur = dummy.next;
         int sum = 0;
         while(a1 != null || a2 != null) {
        	 sum /= 10;
        	 if(a1 != null) {
        		 sum += a1.val;
        		 a1 = a1.next;
        	 }
        	 if(a2 != null) {
        		 sum += a2.val;
        		 a2 = a2.next;
        	 }
        	 cur.next = new ListNode(sum%10);
        	 cur = cur.next;
         }
         if(sum/10 == 1) {
        	 cur.next = new ListNode(1);
         }
         return dummy.next;
    }
}
