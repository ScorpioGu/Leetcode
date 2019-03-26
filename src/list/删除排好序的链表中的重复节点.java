package list;

import support.ListNode;

public class 删除排好序的链表中的重复节点 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // 头节点有可能是会被删除的，所以这里用一个dummy节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy.next;
        ListNode pre = dummy;
        while (cur != null) {
            // 不是一一个重复的删，而是整条连续的一起删
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            // 根据cur，pre是否相邻判断cur有没有出现重复
            if (pre.next == cur) {
                //没有遇到重复的元素，pre,cur都往后移动即可
                pre = pre.next;
                cur = cur.next;
            } else {
                //遇到重复的元素了，cur现在所在的位置就是重复的元素，
                pre.next = cur.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
