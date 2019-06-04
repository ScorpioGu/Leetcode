package linklist;

import support.ListNode;

/**
 * @Desc https://leetcode.com/problems/insertion-sort-linklist/description/
 *
 * Example1:
 * 5 6 3 1 8
 * head -> 5                    6 -> 3 -> 1 -> 8
 * head -> 5 -> 6               3 -> 1 -> 8
 * head -> 3 -> 5 -> 6          1 -> 8
 * head -> 1 -> 3 -> 5 -> 6     8
 * head -> 1 -> 3 -> 5 -> 6 -> 8
 *
 * @Author gcc
 * @Date 18-11-17 下午4:42
 **/
public class 链表插入排序 {
    /**
     * 其实是改变了原有的链表的,新建了一个链表头重新组织了
     * 如果是数组去插入排序,传入一个数组引用,排序之后依然是返回这个数组引用
     * 但是链表的话传进去链表头,排序之后返回的并不是这个链表头了
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if( head == null ){
            return head;
        }

        ListNode dummy = new ListNode(0);
        // 当前待插入的节点
        ListNode cur = head;
        // 用于寻找插入位置，最终将cur插入到pre的后面，每次插入一个新节点，pre要还原回head
        ListNode pre = dummy;
        // 记录下一个待插入的节点，因为cur插入之后，next指针要发生改变，所以这里需要记录
        ListNode next;
        //not the end of input linklist
        while( cur != null ){
            //find the right place to insert
            while( pre.next != null && pre.next.val < cur.val ){
                pre = pre.next;
            }
            // 记录下一个待插入的节点
            next = cur.next;
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;

            // 修改指针，准备下一次插入
            pre = dummy;
            cur = next;
        }

        return dummy.next;
    }
}
