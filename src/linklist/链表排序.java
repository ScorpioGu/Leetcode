package linklist;

import support.ListNode;

/**
 * @Desc https://leetcode.com/problems/sort-linklist/description/
 * Sort a linked linklist in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * @Author gcc
 * @Date 18-11-18 上午10:31
 *
 * 6-13
 **/
public class 链表排序 {
    /**
     * 使用归并排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        //若链表为空或者只有一个节点,则返回,不用排序,这是递归返回的初始条件
        if (head == null || head.next == null) {
            return head;
        }

        // 在链表长度为偶数时，如果希望slow停在前一半的最后一个，则while中条件为fast.next != null && fast.next.next ！= null
        // 如果希望slow停在后一半的第一个，则while中条件为fast != null && fast.next !=null。
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        right = sortList(right);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left == null) {
            cur.next = right;
        } else {
            cur.next = left;
        }
        return dummy.next;
    }
}
