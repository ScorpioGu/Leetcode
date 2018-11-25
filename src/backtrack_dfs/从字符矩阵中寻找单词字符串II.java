package backtrack_dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * @Desc https://leetcode.com/problems/word-search-ii/description/
 * Input:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 *
 * Output: ["eat","oath"]
 *
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * @Author gcc
 * @Date 18-11-25 下午3:33
 **/

public class 从字符矩阵中寻找单词字符串II {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new LinkedList<>();
        if (words == null || words.length == 0 || board == null || board.length == 0) {
            return res;
        }
        //建Trie树
        TrieNode root = buildTrie(words);
        //对每一个位置进行DFS
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, res,root);
            }
        }
        return res;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }
        return root;
    }

    private void dfs(char[][] board, int i, int j, List<String> res, TrieNode cur) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        char c = board[i][j];
        if (c == '#' || cur.children[c - 'a'] == null) {
            return;
        }

        //这里是因为题目已经字符范围是a-z,'#'不在这个范围内可以这么做.
        //但是如果不限定字符范围,则不可以赋值一个保存来保存访问状态,因为'#'可能本身就存在于这个矩阵中
        //可以用board[i][j] ^= 256,
        board[i][j] = '#';

        cur = cur.children[c - 'a'];
        if (cur.word != null) {
            res.add(cur.word);
            cur.word = null;
        }
        dfs(board, i - 1, j, res, cur);
        dfs(board, i + 1, j, res, cur);
        dfs(board, i, j + 1, res, cur);
        dfs(board, i, j - 1, res, cur);

        board[i][j] = c;
    }

    private class TrieNode {
        /**
         * 当前节点为单词时才初始化该字符串,如果仅仅是前缀,则不对其进行赋值
         * 另外,当单词被添加到list中之后,该引用指向null,也就是one-time trie,避免相同的字符串重复添加
         * 存储这个变量之后,StringBuilder也可以不要了,根据word是否为null判断是否到达了终点
         * 到达终点之后,将word添加到list中即可.
         */
        String word;

        TrieNode[] children = new TrieNode[26];
    }




/*
     * dfs,结果是对的,但是会产生TLE,因为isValid与isContinue, 这两个方法太耗时了
     * 每次调用都要去访问所有的单词. 我们需要这个字典的两个目的,一是判断单词是否在这个字典中
     * 二是单词是否有可能在这个字典中(也就是前缀判断).这使我们想起了Trie的search与startWith方法
     * 用Trie来存储这个字典.
     * @param board
     * @param words
     * @return
     *//*
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        if (words == null || words.length == 0 || board == null || board.length == 0) {
            return new ArrayList<>(res);
        }

        //对每一个位置进行DFS
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, res, new StringBuilder(), words);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, int i, int j, Set<String> res, StringBuilder sb, String[] words) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
            return;
        }
        sb.append(board[i][j]);
        board[i][j] ^= 256;
        if (isValid(sb.toString(), words)) {
            res.add(sb.toString());
        }
        if (isContinue(sb.toString(), words)) {
            dfs(board, i + 1, j, res, sb, words);
            dfs(board, i - 1, j, res, sb, words);
            dfs(board, i , j + 1, res, sb, words);
            dfs(board, i , j - 1, res, sb, words);
        }
        board[i][j] ^= 256;
        sb.deleteCharAt(sb.length() - 1);
    }

    private boolean isValid(String s, String[] words) {
        for (String word : words) {
            if (s.equals(word)) {
                return true;
            }
        }
        return false;
    }

    private boolean isContinue(String s, String[] words) {
        for (String word : words) {
            if (word.startsWith(s)) {
                return true;
            }
        }
        return false;
    }*/

    public static void main(String[] args) {
        char[][] chs = {
                {'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}
        };
        String[] words = {"eat", "oath"};
        System.out.println(new 从字符矩阵中寻找单词字符串II().findWords(chs, words));
    }
}
