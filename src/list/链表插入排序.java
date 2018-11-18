package list;

import support.ListNode;

/**
 * @Desc https://leetcode.com/problems/insertion-sort-list/description/
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

        ListNode helper = new ListNode(0);
        ListNode cur = head;
        ListNode pre = helper;
        ListNode next;
        //not the end of input list
        while( cur != null ){
            next = cur.next;
            //find the right place to insert
            while( pre.next != null && pre.next.val < cur.val ){
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }

        return helper.next;
    }
}
