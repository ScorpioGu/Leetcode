package slide_window;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc https://leetcode.com/problems/minimum-window-substring/description/
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 * @Author gcc
 * @Date 18-10-29 下午10:39
 **/
public class 包含子串所有字符的最短子串 {
    /**
     * 这道题要求包含子串中所有的字符，并且子串中可能会有重复的字符，不用考虑顺序，只要全部包括就可以
     * 那么可以使用HashMap来存储（子串中的所有字符及其出现的次数) - (当前窗口中的所有字符及其出现次数)。
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // map.get(c)代表为使得窗口valid，仍然需要的字符c的个数
        Map<Character, Integer> map = new HashMap<>();
        for (Character c:t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0;
        //记录最短的窗口的左边界
        int minLeft = 0;
        int minLen = Integer.MAX_VALUE;
        //记录窗口中为匹配上子串还需要的字符数量，如果该值等于0了，则当前窗口全部包括了子串的所有字符
        int count = map.size();

        while (r < s.length()) {
            char rchar = s.charAt(r);
            if (map.containsKey(rchar)) {
                map.put(rchar, map.get(rchar) - 1);
                if (map.get(rchar) == 0) {
                    count--;
                }
            }
            while (count == 0) {

                //当遇到子串中的字符时，首先更新map，进行判断是否这个字符是多余的，即是否窗口中含有该字符的数量已经大于子串中该字符串的数量了
                //对应的情形是map中该字符对应的value是负值。而如果map中该字符对应的value>=0，则该字符是必要的，左边界移动之后
                //该窗口便不再能够包含子串中的所有字符了，此时要更新count。
                char lchar = s.charAt(l);
                if (map.containsKey(lchar)) {
                    map.put(lchar, map.get(lchar) + 1);
                    if (map.get(lchar) > 0) {
                        count++;
                    }
                }

                // 更新最优解
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    minLeft = l;
                }

                //最终left移动到使得窗口不匹配的第一个位置，然后跳出while循环，继续移动右边界，寻找在该左边界的条件下的匹配窗口。
                l++;
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

}
