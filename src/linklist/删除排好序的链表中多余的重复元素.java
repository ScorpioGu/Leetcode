package linklist;

import support.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class 删除排好序的链表中多余的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 我们的策略是保留重复元素中的最后一个，所以头节点是有可能被删除的，pre=dummy
        ListNode pre = dummy;
        ListNode cur = pre.next;


        while (cur != null) {
            while (cur.next != null && cur.next.val == cur.val) {
                // cur停在最后一个重复的节点上
                cur = cur.next;
            }
            // 如果没有重复，这句话没有任何影响，如果cur值出现了重复，这句话将删除多余的重复节点
            pre.next = cur;


            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
