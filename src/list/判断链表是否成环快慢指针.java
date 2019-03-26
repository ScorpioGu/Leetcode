package list;

import support.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle/description/
 * <p>
 * Given a linked list, determine if it has a cycle in it.
 */
public class 判断链表是否成环快慢指针 {
    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        // 因为fast一定大于等于slow的，所以只需要对fast和fast.next进行判空即可
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
