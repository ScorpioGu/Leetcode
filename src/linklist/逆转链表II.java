package linklist;

import support.ListNode;

/**
 * https://leetcode.com/problems/rotate-list/
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 *
 * 6-13
 */
public class 逆转链表II {
    /**
     * 从倒数第k个开始的一段放前面
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int len = 0;
        //要先知道链表的长度，为了定位slow，而且k可以大于链表长度，取余要用到
        while (fast.next != null) {
            len++;
            fast = fast.next;
        }

        for (int i = len - k % len; i > 0; i--) {
            slow = slow.next;
        }
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;

    }

}
