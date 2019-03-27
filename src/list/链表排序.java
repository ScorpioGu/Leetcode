package list;

import support.ListNode;

/**
 * @Desc https://leetcode.com/problems/sort-list/description/
 * Sort a linked list in O(n log n) time using constant space complexity.
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
        //将链表分成两截,pre保存着slow的前驱,用于截断链表
        //右半边链表的链表头一定是slow，而不能是slow.next,所以需要去记录slow的前驱用于截断
        //想象一下一个只能两个节点的链表，slow最终将停在第2个节点处。如果用slow.next做第二段的链表头
        //分割下来，第一段有两个节点，第二段有0个节点，显然这是不合适的
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);
    }

    /**
     * 合并两链表
     * @param left
     * @param right
     * @return
     */
    private ListNode merge(ListNode left, ListNode right) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (left != null && right != null) {
            if (left.val > right.val) {
                cur.next = right;
                right = right.next;
            } else {
                cur.next = left;
                left = left.next;
            }
            cur = cur.next;
        }
        //执行到这里可能有左边或者右边还有剩着的,因为是链表,所以直接cur.next = left/right
        //把一条链表整体放在了新链表后面
        if (left != null) {
            cur.next = left;
        }
        if (right != null) {
            cur.next = right;
        }
        return res.next;
    }
}
