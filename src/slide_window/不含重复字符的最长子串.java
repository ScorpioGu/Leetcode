package slide_window;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class 不含重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int l = 0, r = 0;
        while (r < s.length()) {
            char rchar = s.charAt(r);
            // from invalid to valid
            if (map.containsKey(rchar)) {
                //当发现重复元素但是重复元素在当前子串的起始位置之前，子串的起始位置是不需要变的
                //只有当重复元素的位置大于左边界时，子串需要改变，因为当前子串中存在了重复字符
                l = Math.max(l, map.get(rchar) + 1);
            }
            map.put(rchar, r);
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}
