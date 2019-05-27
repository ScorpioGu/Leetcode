package huiwen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc https://leetcode.com/problems/palindrome-pairs/
 * //TODO 这题也好难,值得好好回味
 * @Author gcc
 * @Date 19-1-4 下午3:16
 **/
public class 寻找字符串数组中的回文对 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            addNode(root, words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            searchNode(root, words[i], i, res);
        }
        return res;
    }


    private void addNode(TrieNode root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int j = word.charAt(i) - 'a';
            if (root.next[j] == null) {
                root.next[j] = new TrieNode();
            }

            if (isPal(word, 0, i)) {
                root.list.add(index);
            }

            root = root.next[j];

        }
        //到此最后一个字符所在的节点了,节点剩余部位就是空串了,也认为是回文串,可以list.add(index)
        //而且该节点是一个单词,修改其索引
        root.list.add(index);
        root.index = index;
    }


    private void searchNode(TrieNode root, String word, int index, List<List<Integer>> res) {
        for (int i = 0; i < word.length(); i++) {
            //当前节点是单词,并且查找的单词节点和Trie中当前的不是同一个,并且剩余部分是回文串的 那么就是一个回文对
            if (root.index >= 0 && root.index != index && isPal(word, i, word.length() - 1)) {
                res.add(Arrays.asList(index, root.index));
            }

            root = root.next[word.charAt(i) - 'a'];
            if (root == null) {
                return;
            }
        }

        for (int j : root.list) {
            if (index == j) {
                continue;
            }
            res.add(Arrays.asList(index, j));
        }
    }




    /**
     * 判断word的[i,j]部分是否是回文串
     * @param word
     * @param i
     * @param j
     * @return
     */
    private boolean isPal(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}

class TrieNode {
    /**
     * 如果当当前节点是数组中单词的话,记录它在数组中的索引
     */
    int index;

    /**
     * 记录满足下面两个条件的单词的索引
     * 1. 当前的节点是单词的后缀
     * 2. 满足1的情况下,剩余部分是回文的
     */
    List<Integer> list;

    /**
     * 记录下一层的节点,对与字符c,它所存放的索引应是c - 'a'
     */
    TrieNode[] next;

    TrieNode() {
        index = - 1;
        list = new ArrayList<>();
        next = new TrieNode[26];
    }
}
