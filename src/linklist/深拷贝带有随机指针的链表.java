package linklist;

/**
 * @Desc https://leetcode.com/problems/copy-linklist-with-random-pointer/description/
 * A linked linklist is given such that each node contains an additional random pointer which could point to any node in the linklist or null.
 *
 * Return a deep copy of the linklist.
 *
 * TODO
 * @Author gcc
 * @Date 18-11-16 下午10:14
 **/
public class 深拷贝带有随机指针的链表 {
    /**
     * https://blog.csdn.net/linhuanmars/article/details/22463599/
     * O(1)时间复杂度
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode cur = head;
        /**
         * 第一轮遍历,生成新节点,并使得两链表的next指针指向如下面所示
         * o o o ...
         * |/|/|
         * o o o ...
         */
        while (cur != null) {
            RandomListNode newNode = new RandomListNode(cur.label);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }

        //第二轮遍历,赋值新节点的random指针,因为此时旧节点的的next指针指向它的复制节点
        cur = head;
        while (cur != null) {
            //这里cur.next不用判空,因为cur.next指向的cur的复制节点,因为cur不为空,其复制节点一定存在
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        //复原两个串,
        cur = head;
        RandomListNode newHead = cur.next;
        while (cur != null) {
            RandomListNode node = cur.next;
            cur.next = node.next;
            if (node.next != null) {
                node.next = node.next.next;
            }
            cur = cur.next;
        }
        return newHead;
    }
}


class RandomListNode {
  int label;
  RandomListNode next, random;
  RandomListNode(int x) {
      this.label = x; }
}
