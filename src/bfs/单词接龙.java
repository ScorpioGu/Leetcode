package bfs;

import java.util.LinkedList;
import java.util.List;

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
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        int res = 1;
        LinkedList<String> queue=new LinkedList<>();
        queue.offer(beginWord);

        wordList.remove(beginWord);
        while(!queue.isEmpty())
        {
            int size=queue.size();
            while(size>0)
            {
                String s=queue.poll();
                size--;

                char[] cs = s.toCharArray();
                for (int i = 0; i < s.length(); i++) {
                    char pre = cs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == pre) {
                            continue;
                        }
                        cs[i] = c;
                        String neighbor = new String(cs);
                        if (neighbor.equals(endWord)) {
                            return res + 1;
                        }
                        if (wordList.contains(neighbor)) {
                            queue.offer(neighbor);

                            // 为了遍历不重复需将字典中找到的字符串删除
                            wordList.remove(neighbor);
                        }
                    }
                    cs[i] = pre;
                }
            }
            res++;
        }
        return 0;
    }
}

