package list;

import support.ListNode;

import java.util.PriorityQueue;

//https://leetcode.com/problems/merge-k-sorted-lists/description/

//基于优先级队列和分治两种策略求解
public class 多个排序链表合成一个排序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
//        优先队列的头是基于自然排序或者Comparator排序的最小元素,不允许出现null
        //根据节点的val升序排列，对头元素是最小的
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> (a.val - b.val));
        for (ListNode node : lists) {
            if (node != null) {
                //添加的时候自动根据val值排列了
                queue.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!queue.isEmpty()) {
            //queue取出对头元素，此时一定是最小的，然后把该链表从队列中删掉
            tail.next = queue.poll();
            tail = tail.next;

            //此时tail.next指向刚才被删掉的链表中的第二个节点，将它入队，因为这个链表中剩余的节点还没访问过
            if (tail.next != null) {
                queue.add(tail.next);
            }
        }
        return dummy.next;
    }

    //回溯来做
    public ListNode mergeKListsRecursive(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        helper(tail, lists);
        return dummy.next;

    }

    private void helper(ListNode tail, ListNode[] lists) {
        if (isEmpty(lists)) {
            return;
        }
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < min) {
                min = lists[i].val;
                minIndex = i;
            }
        }
        tail.next = lists[minIndex];
        lists[minIndex] = lists[minIndex].next;
        helper(tail.next, lists);
    }

    private boolean isEmpty(ListNode[] lists) {
        for (ListNode node : lists) {
            if (node != null) {
                return false;
            }
        }
        return true;
    }

    //分治来做，之前有做过两个链表合成的题目，那么这个题目可以分治成两个链表合成的子问题，然后再去merge
    public ListNode mergeKListsDivid(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }

    private ListNode helper(ListNode[] lists, int begin, int end) {
        if (begin == end) {
            return lists[begin];
        }
        if (begin < end) {
            int mid = (begin + end) / 2;
            ListNode node1 = helper(lists, begin, mid);
            ListNode node2 = helper(lists, mid+1, end);
            return merge(node1, node2);
        }
        return null;
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null)
            return node2;
        if (node2 == null)
            return node1;

        ListNode dummy = new ListNode(0);
        ListNode tail= dummy;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                tail.next = node1;
                node1 = node1.next;
                tail = tail.next;
            } else {
                tail.next = node2;
                node2 = node2.next;
                tail = tail.next;

            }
        }

        while (node1 != null) {
            tail.next = node1;
            node1 = node1.next;
            tail = tail.next;

        }
        while (node2 != null) {
            tail.next = node2;
            node2 = node2.next;
            tail = tail.next;

        }
        return dummy.next;
    }















}
