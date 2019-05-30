package slide_window;

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
    /**
     * 使用双指针要保持单调性，在这个题目里的体现，就是右边界扩，不同字符个数不会减只会增加或者不变
     * 左边界扩，不同字符个数不会增加只会减少或者不变
     * @param s
     * @param k
     * @return
     */
    public int lengthOfLongestSubstringTwoDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = 0;
        int l = 0, r = 0;
        //map存字符及其出现的次数
        Map<Character, Integer> map = new HashMap<>();
        while (r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            // from invalid to valid
            while (map.size() > k) {
                //先不断减少次数,并向右移动left,当次数到0的时候remove掉
                map.put(s.charAt(l),map.get(s.charAt(l)) - 1);
                if (map.get(s.charAt(l)) == 0) {
                    map.remove(s.charAt(l));
                }
                l++;
            }
            len = Math.max(len, r - l + 1);
            r++;
        }
        return len;
    }
}
