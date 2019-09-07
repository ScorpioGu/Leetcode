package linklist;

import support.ListNode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 * 6-13
 */
public class 合并k个排序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> (a.val - b.val));
        for (ListNode node : lists) {
            if (node != null) {
                //添加的时候自动根据val值排列了
                queue.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (!queue.isEmpty()) {
            //queue取出对头元素，此时一定是最小的，然后把该链表从队列中删掉
            cur.next = queue.poll();
            cur = cur.next;

            //此时tail.next指向刚才被删掉的链表中的第二个节点，将它入队，因为这个链表中剩余的节点还没访问过
            if (cur.next != null) {
                queue.add(cur.next);
            }
        }


        return dummy.next;
    }
}
