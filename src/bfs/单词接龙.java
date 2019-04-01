package bfs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Desc https://leetcode.com/problems/word-ladder/description/
 *
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * @Author gcc
 * @Date 18-11-11 下午5:10
 **/
public class 单词接龙 {
    /**
     * 双端BFS来做减少时间复杂度
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0 || !wordList.contains(endWord)) {
            return 0;
        }
        int strLen = beginWord.length();
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();
        start.add(beginWord);
        end.add(endWord);
        int len = 1;
        while (!start.isEmpty() && !end.isEmpty()) {
            //交换,保持start与end的size接近,能减少时间复杂度
            if (start.size() > end.size()) {
                Set<String> tmp = start;
                start = end;
                end = tmp;
            }
            //set是无序的,所以用队列中常使用的记录size判断这一层是否结束是不可行的,不像队列每次都插入到尾部
            //用一个tmp存储下一层的节点,当这一层遍历结束之后,移动start指针指向下一层的set
            Set<String> tmp = new HashSet<>();
            for (String s : start) {
                char[] chars = s.toCharArray();
                for (int i = 0; i < strLen; i++) {
                    char pre = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String newS = String.valueOf(chars);
                        if (end.contains(newS)) {
                            return len + 1;
                        }
                        if (wordList.contains(newS)) {
                            tmp.add(newS);
                            wordList.remove(newS);
                        }
                    }
                    chars[i] = pre;
                }
            }
            start = tmp;
            len++;
        }
        return 0;
    }

}
