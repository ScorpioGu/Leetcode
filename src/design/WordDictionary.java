package design;

/**
 * @Desc https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 *
 * Trie那题我们用HashMap来做的,这题我们尝试用数组来做
 * @Author gcc
 * @Date 18-11-25 下午2:42
 **/
public class WordDictionary {

    // 根节点
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return isMatch(word.toCharArray(), 0, root);
    }


    private boolean isMatch(char[] chs, int index, TrieNode cur) {
        if (index == chs.length) {
            //所有字符都能找到,并且cur是一个单词,返回true
            return cur.isWord;
        }
        char c = chs[index];
        if (c == '.') {
            //cur所有不为空的下层节点均可以作为路径
            for (TrieNode child : cur.children) {
                if (child != null && isMatch(chs, index + 1, child)) {
                    return true;
                }
            }
        } else {
            //只有下标为c - 'a'的节点不为空时才可以作为路径
            if (cur.children[c - 'a'] != null && isMatch(chs, index + 1, cur.children[c - 'a'])) {
                return true;
            }
        }
        return false;
    }

    private class TrieNode {

        // 根据需要可以加其他字段项
        // 比如int path， int end
        // path代表有多少词以这条路径为前缀，end表示有多少这个词
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
    }

}
