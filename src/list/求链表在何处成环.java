package list;

import support.ListNode;

/**
 * @Desc https://leetcode.com/problems/linked-list-cycle-ii/description/
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Note: Do not modify the linked list.
 * @Author gcc
 * @Date 18-11-17 下午12:57
 **/
public class 求链表在何处成环 {
    /**
     * 推导见
     * https://leetcode.com/problems/linked-list-cycle-ii/discuss/44781/Concise-O(n)-solution-by-using-C++-with-Detailed-Alogrithm-Description
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        boolean isCycle = false;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                isCycle = true;
                break;
            }
        }
        if (!isCycle) {
            return null;
        }

        //在他两相遇之后将其中一个节点放到链表起点,再一起同步前进
        //再次遇到的点就一定是链表成环的地方
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
