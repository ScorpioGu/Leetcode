package linklist;

import support.ListNode;

//寻找两个链表的交叉点,因为节点的next指针只有一个,所以必然有公共尾部
//		A:          a1 → a2
//							↘
//								c1 → c2 → c3
//							↗
//		B:     b1 → b2 → b3
public class 寻找两个链表的公共部分 {
    /**
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 首先判断两个链表本身是否成环
        ListNode loopA = getLoop(headA);
        ListNode loopB = getLoop(headB);

        // 两个都不成环
        if (loopA == null && loopB == null) {
            return getInsecNoLoop(headA, headB, null);
        }


        // 两个都成环
        if (loopA != null && loopB != null) {
            return getBothLoop(headA, headB, loopA, loopB);
        }

        // 一个成环，另一个不成环,这种情况，两链表必然不相交
        return null;

    }

    /**
     *
     * @return 如果链表不成环，null,否则返回成环的点
     */
    private ListNode getLoop(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean loop = false;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                loop = true;
                break;
            }
        }
        if (!loop) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     *
     * @param a
     * @param b
     * @param end
     * @return a,b的交点，如果两个中任意一个跑到了end，而另一个没跑到，返回null
     */
    private ListNode getInsecNoLoop(ListNode a, ListNode b, ListNode end) {
        // 获取两链表，直到end的长度
        int lenA = 1, lenB = 1;
        // curA, curB跑到最后一个节点上
        ListNode curA = a, curB = b;
        while (curA.next != end) {
            lenA++;
            curA = curA.next;
        }
        while (curB.next != end) {
            lenB++;
            curB = curB.next;
        }
        // 如果交叉了，最后一个节点必然是同一个，如果不是，必然不交叉
        if (curA != curB) {
            return null;
        }

        // 让a成为长的那个
        if (lenA < lenB) {
            ListNode tmp = a;
            a = b;
            b = tmp;
        }
        // a多跑一段
        for (int i = 0; i < Math.abs(lenA - lenB); i++) {
            a = a.next;
        }
        while (a != end && b != end && a != b) {
            a = a.next;
            b = b.next;
            if (a == b) {
                return a;
            }
        }
        return null;
    }

    private ListNode getBothLoop(ListNode headA, ListNode headB, ListNode loopA, ListNode loopB) {
        // 找到环的入口，环的拓扑有两种
        if (loopA == loopB) {
            return getInsecNoLoop(headA, headB, loopA);
        }
        // loopA走一圈看能否遇到loopB，如果遇不到，说明不成环
        ListNode cur = loopA.next;
        while (cur != loopA) {
            if (cur == loopB) {
                return loopA;
            }
            cur = cur.next;
        }
        return null;
    }
}