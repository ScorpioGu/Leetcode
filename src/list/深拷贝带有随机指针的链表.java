package list;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc https://leetcode.com/problems/copy-list-with-random-pointer/description/
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 * @Author gcc
 * @Date 18-11-16 下午10:14
 **/
public class 深拷贝带有随机指针的链表 {
    /**
     * 使用map存储新旧节点的对应关系
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        RandomListNode cur1 = head.next;
        RandomListNode cur2 = newHead;
        while (cur1 != null) {
            RandomListNode node = new RandomListNode(cur1.label);
            map.put(cur1, node);
            cur2.next = node;
            cur2 = cur2.next;
            cur1 = cur1.next;
        }

        cur1 = head;
        cur2 = newHead;
        while (cur1 != null) {
            cur2.random = map.get(cur1.random);
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return newHead;
    }

    //TODO
}


class RandomListNode {
  int label;
  RandomListNode next, random;
  RandomListNode(int x) {
      this.label = x; }
}
