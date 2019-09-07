package linklist;

/**
 * @Desc https://leetcode.com/problems/copy-linklist-with-random-pointer/description/
 * A linked linklist is given such that each node contains an additional random pointer which could point to any node in the linklist or null.
 *
 * Return a deep copy of the linklist.
 *
 *
 * @Author gcc
 * @Date 18-11-16 下午10:14
 *
 * 6-16
 **/
public class 深拷贝带有随机指针的链表 {
    /**
     * https://blog.csdn.net/linhuanmars/article/details/22463599/
     * O(1)时间复杂度
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur1 = head;
        /**
         * 第一轮遍历,生成新节点,并使得两链表的next指针指向如下面所示
         * o o o ...
         * |/|/|
         * o o o ...
         */
        while (cur1 != null) {
            Node newNode = new Node(cur1.label);
            newNode.next = cur1.next;
            cur1.next = newNode;
            cur1 = newNode.next;
        }

        //第二轮遍历,赋值新节点的random指针,因为此时旧节点的的next指针指向它的复制节点
        cur1 = head;
        while (cur1 != null) {
            //这里cur.next不用判空,因为cur.next指向的cur的复制节点,因为cur不为空,其复制节点一定存在
            if (cur1.random != null) {
                cur1.next.random = cur1.random.next;
            }
            cur1 = cur1.next.next;
        }

        //复原两个串,
        cur1 = head;
        Node newHead = cur1.next;
        while (cur1 != null) {
            Node node = cur1.next;
            cur1.next = node.next;
            if (node.next != null) {
                node.next = node.next.next;
            }
            cur1 = cur1.next;
        }
        return newHead;
    }
}


class Node {
  int label;
  Node next, random;
  Node(int x) {
      this.label = x; }
}
