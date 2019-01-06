package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc https://www.cnblogs.com/grandyang/p/5185561.html
 *
 * Given a string S, find the length of the longest substring T that contains at most two distinct characters.
 * For example,
 * Given S = “eceba”,
 * T is “ece” which its length is 3.
 * @Author gcc
 * @Date 18-11-19 下午8:36
 **/
public class 最多有k个不同字符的最长子串 {
    public int lengthOfLongestSubstringTwoDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = 0;
        int l = 0, r = 0;
        //map存字符及其出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for (r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            while (map.size() > k) {
                //先不断减少次数,并向右移动left,当次数到0的时候remove掉
                map.put(s.charAt(l),map.get(s.charAt(l)) - 1);
                if (map.get(s.charAt(l)) == 0) {
                    map.remove(s.charAt(l));
                }
                l++;
            }
            len = Math.max(len, r - l + 1);
        }
        return len;
    }

    /**
     * map也可以换成存储字符及其最新下标来做
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringTwoDistinct2(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = 0;
        int l = 0, r = 0;
        //map存字符和最新的下标
        Map<Character, Integer> map = new HashMap<>();
        for (r = 0; r < s.length(); r++) {
            //没有就新增,有就更新
            map.put(s.charAt(r), r);
            while (map.size() > k) {
                //left不断向右跑,跑到map中有value和他相同,此时,left停在了该被删除的字符上
                if (map.get(s.charAt(l)) == l) {
                    map.remove(s.charAt(l));
                }
                l++;
            }
            len = Math.max(len, r - l + 1);
        }
        return len;
    }

}
