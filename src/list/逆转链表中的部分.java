package list;

import support.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/submissions/
 */
public class 逆转链表中的部分 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        //pre移动到m-1个节点出，之后pre保持不变
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        // 使用三个指针,pre,cur,next pre总是保持不变,pre.next指向cur即待旋转的位置,next是cur的后继
        //每次for循环之后，start在第i个位置，then在第i+1个位置。
        ListNode cur = pre.next;
        ListNode next = cur.next;
        for (int i = 0; i < n - m; i++) {
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = cur.next;
        }
        return dummy.next;
    }
}
