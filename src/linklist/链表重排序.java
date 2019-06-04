package linklist;

import support.ListNode;

/**
 * @Desc https://leetcode.com/problems/reorder-linklist/description/
 * Given a singly linked linklist L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the linklist's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * @Author gcc
 * @Date 18-11-17 下午1:21
 **/
public class 链表重排序 {
    public void reorderList(ListNode head) {
        //快慢指针跑到链表中间
        if (head == null) {
            return;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        if (newHead == null) {
            return;
        }
        slow.next = null;

        //对后面一半部分逆转
        ListNode pre = null;
        ListNode cur = newHead;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        //合并两链表
        cur = head;
        while (pre != null && cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = pre.next;
            cur.next.next = tmp;
            cur = tmp;
        }
    }
}
