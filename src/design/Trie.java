package design;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc https://leetcode.com/problems/implement-trie-prefix-tree/description/
 * Implement a trie with insert, search, and startsWith methods.
 * @Author gcc
 * @Date 18-11-23 下午8:51
 **/
public class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chs = word.toCharArray();
        TrieNode cur = root;
        for (char ch : chs) {
            if (!cur.map.containsKey(ch)) {
                cur.map.put(ch, new TrieNode());
            }
            cur = cur.map.get(ch);
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chs = word.toCharArray();
        TrieNode cur = root;
        for (char ch : chs) {
            if (!cur.map.containsKey(ch)) {
                return false;
            }
            cur = cur.map.get(ch);
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chs = prefix.toCharArray();
        TrieNode cur = root;
        for (char ch : chs) {
            if (!cur.map.containsKey(ch)) {
                return false;
            }
            cur = cur.map.get(ch);
        }
        return true;
    }


    private class TrieNode {
        //如果用List存储下一层节点的话,用contains判断下一层是否存在当前字符会比较麻烦
        //如果用长度为26的数组的话,会比较方便,但是每个节点都创建这么长一个数组的话,太浪费空间了把
        //用HashMap来存储吧,key就是字符,而value则就是下一层节点

        boolean isWord;
        Map<Character, TrieNode> map;

        public TrieNode() {
            map = new HashMap<>();
        }
    }
}