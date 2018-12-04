package string;

import java.util.List;

/**
 * @Desc https://www.cnblogs.com/grandyang/p/5187041.html
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 *
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 *
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list
 * @Author gcc
 * @Date 18-12-4 上午9:36
 **/
public class 最短单词距离 {
    /**
     * 使用两个int变量记录找到单词时的下标,在两单词都能找到之后
     * 一旦下标出现了变化,就去尝试计算新的距离与原有最小值比较
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    int shortestDistance(List<Integer> words, String word1, String word2) {
        int i1 = -1, i2 = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals(word1)) {
                i1 = i;
            }
            if (words.get(i).equals(word2)) {
                i2 = i;
            }
            if (i1 != - 1 && i2 != -1) {
                min = Math.min(Math.abs(i1 - i2), min);
            }
        }
        return min;
    }
}
