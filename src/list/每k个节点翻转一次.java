package list;

import support.ListNode;
//https://leetcode.com/problems/reverse-nodes-in-k-group/description/
public class 每k个节点翻转一次 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }

        if (count == k) {
            //对应于找到第k+1个节点,如果找到了就去翻转，没找到就不翻转。

            cur = reverseKGroup(cur, k);
            //翻转，每次循环都始终修改head指向cur。
            while (count-- != 0) {
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }
        //最后返回的就是head，无论是否翻转，用head指向头节点。
        return head;
    }
}
