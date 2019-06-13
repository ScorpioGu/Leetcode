package linklist;

import support.ListNode;
/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * 6-13
 */
public class 每k个节点逆转一次 {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode cur = head;

        // 判断是否有k个节点，如果没则不用反转
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }

        if (count == k) {
            //对应于找到第k+1个节点,如果找到了就去翻转，没找到就不翻转。
            cur = reverseKGroup(cur, k);
            //翻转，每次循环都始终修改head指向cur。
/*            while (count-- != 0) {

                // head指向1，cur指向5，如下反转方式
                // 1>2>3 4>5
                // 2>3 1>4>5
                // 3 2>1>4>5
                // 3>2>1>4>5
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;


            }
            head = cur;*/

            // 这样翻转也是可以的
            // 1>2>3 4>5
            // 1<2 3 4>5
            // 1<2<3 4<5
            // 3>2>1>4>5
            ListNode pre = null, curr = head;
            while (count != 0) {
                ListNode temp = curr.next;
                curr.next = pre;
                pre = curr;
                curr = temp;
                count--;
            }
            head.next = cur;
            return curr;
        }
        //最后返回的就是head，无论是否翻转，用head指向头节点。
        return head;
    }
}
