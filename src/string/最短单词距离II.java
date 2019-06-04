package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc http://www.cnblogs.com/grandyang/p/5187640.html
 * This is a follow up of Shortest Word Distance. The only difference is now you are given the linklist of words and your method will be called repeatedly many times with different parameters. How would you optimize it?
 * <p>
 * Design a class which receives a linklist of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the linklist.
 * <p>
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p>
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 * <p>
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the linklist.
 * <p>
 * 这道题是之前那道Shortest Word Distance的拓展，不同的是这次我们需要多次调用求最短单词距离的函数.以空间复杂度换取时间复杂度
 * @Author gcc
 * @Date 18-12-4 上午9:43
 **/
public class 最短单词距离II {
    private Map<String, List<Integer>> mem = new HashMap<>();

    public 最短单词距离II(String[] words) {
        for(int i=0; i<words.length; i++){
            if(mem.containsKey(words[i])){
                mem.get(words[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                mem.put(words[i], list);
            }
        }
    }

    int shortest(String word1, String word2) {
        List<Integer> l1 = mem.get(word1);
        List<Integer> l2 = mem.get(word2);
        int i = 0, j = 0;
        int res = Integer.MAX_VALUE;
        //因为要寻找的是i,j之间的最短距离,所以每次移动都希望将两指针靠的越来越近
        //时间复杂度o(m+n)
        while (i < l1.size() && j < l2.size()) {
            res = Math.min(res, Math.abs(l1.get(i) - l2.get(j)));
            if (i < j) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
