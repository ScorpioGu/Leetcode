package list;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc https://leetcode.com/problems/lru-cache/description/
 * 实现LRU缓存, get, put的时间复杂度为o(1)
 *
 * 使用HashMap配合双向链表,一方面是通过key查找需要操作的节点时间复杂度要o(1),那么想到使用HashMap
 * 双向链表删除和添加节点的时间复杂度是o(1),并且双向链表可以自己删除自己.
 * @Author gcc
 * @Date 18-11-17 下午3:07
 **/
public class LRUCache {
    int count;
    int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> map = new HashMap<>();

    /**
     * 节点删除自身
     * @param node
     */
    private void deleteSelf(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    /**
     * 添加node到队头
     * @param node
     */
    private void offer(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next = node;
        node.next.pre = node;
    }

    /**
     * 删除队尾元素
     */
    private Node pop() {
        Node node = tail.pre;
        deleteSelf(node);
        return node;
    }


    private void removeToHead(Node node) {
        deleteSelf(node);
        offer(node);
    }

    public LRUCache(int capacity) {
        count = 0;
        this.capacity = capacity;
        //使用head, tail两个dummy指针方便操作
        head = new Node();
        tail = new Node();
        head.pre = null;
        head.next = tail;
        tail.pre = head;
        tail.next = null;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        removeToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node();
            node.value = value;
            node.key = key;

            map.put(key, node);
            offer(node);
            count++;
            if (count > capacity) {
                map.remove(pop().key);
            }
        } else {
            node.value = value;
            removeToHead(node);
        }
    }

    class Node {
        int key;
        int value;
        Node pre;
        Node next;
    }
}
