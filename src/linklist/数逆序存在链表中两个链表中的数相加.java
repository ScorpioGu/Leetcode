package linklist;


import support.ListNode;

//数逆序存在链表中，将两数相加，同样以逆序存在一个新的链表中。
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.

//其实逆序降低了难度，进位往下一个位置进就行了，如果是顺序，进位还要访问前一个元素。

/**
 * https://leetcode.com/problems/add-two-numbers/
 * 头条笔试题
 * 6-13
 */
public class 数逆序存在链表中两个链表中的数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         if(l1 == null) return l2;
         if(l2 == null) return l1;
         ListNode a1 = l1;
         ListNode a2 = l2;
         ListNode dummy = new ListNode(0);
         //cur会移动，dummy.next指向链表头
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
         //到最后了，如果还有进位，再生成一个节点保存
         if(sum/10 == 1) {
        	 cur.next = new ListNode(1);
         }
         return dummy.next;
    }
}
