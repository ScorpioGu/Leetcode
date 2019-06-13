/**
 * Author:   gucheng
 * Date:     18-4-29 下午4:56
 * Description: http://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * 有序链表构造成BST，相比数组来说，数组找中间元素直接length/2就完事了，但是链表要使用快慢指针来做。
 * 另外一点，相比数组，链表节点不能访问前一个节点，如root.left = helper(head, slow)而不能helper(head, slow.last)
 * 即，根节点的那个元素被包含到左边的链表中了。为解决可能重复添加的问题，在helper方法中，head == tail 则返回null,
 * 解决。
 */
package tree;

import support.ListNode;
import support.TreeNode;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 * 6-13
 */
public class 排好序的链表转成BST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        // 双指针跑到终点
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        if (pre != null)
            pre.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }

}
