package string;

/**
 * @Desc http://www.cnblogs.com/grandyang/p/5192426.html
 * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
 *
 * Given a linklist of words and two words word1 and word2, return the shortest distance between these two words in the linklist.
 *
 * word1 and word2 may be the same and they represent two individual words in the linklist.
 *
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Given word1 = “makes”, word2 = “coding”, return 1.
 * Given word1 = "makes", word2 = "makes", return 3.
 *
 * Note:
 * You may assume word1 and word2 are both in the linklist.
 *
 * 与第一题的区别,在于word1与word2可能相同
 * @Author gcc
 * @Date 18-12-4 上午10:11
 **/
public class 最短单词距离III {
    int shortestDistance(String[] words, String word1, String word2) {
        int idx = -1, res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                //如果word1 == word2，遇到只要满足words[i].equals(word1) || words[i].equals(word2)的条件都可以
                //比较一下．如果word1 != word2,那么只有在前一个位置的字符串和当前位置的字符串不同时才能够比较
                if (idx == -1 && (word1 == word2 || words[idx] != words[i])) {
                    res = Math.min(res, Math.abs(idx - i));
                }
                idx = i;
            }
        }
        return res;
    }
}
