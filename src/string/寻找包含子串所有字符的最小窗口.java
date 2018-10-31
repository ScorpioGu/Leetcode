package string;

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
public class 寻找包含子串所有字符的最小窗口 {
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
        Map<Character, Integer> map = new HashMap<>();
        for (Character c:t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //窗口左边界，随着主串遍历一直向前滑动
        int left = 0;
        //记录最短的窗口的左边界
        int minLeft = 0;
        //记录包含子串的字符数量，如果该值等于子串长度了，则当前窗口全部包括了子串的所有字符
        int count = 0;
        //记录最短的窗口的长度
        int minLen = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            //先扩张右边界
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if (map.get(s.charAt(right)) >= 0) {
                    count++;
                }

                //举个例子"ADBANC"，T = "ABC"，先一直扩张右边界，直到窗口为ADBANC匹配上了，然后要收缩左边界直到不匹配。
                while (count == t.length()) {
                    if (right - left + 1 < minLen) {
                        minLen = right - left;
                        minLeft = left;
                    }

                    //当遇到子串中的字符时，首先更新map，进行判断是否这个字符是多余的，即窗口中含有该字符的数量已经大于子串中该字符串的数量了
                    //对应的情形是map中该字符对应的value是负值。而如果map中该字符对应的value>=0，则该字符是必要的，左边界移动之后
                    //该窗口便不再能够包含子串中的所有字符了，此时要更新count。
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left)) > 0) {
                            count--;
                        }
                    }

                    //最终left移动到使得窗口不匹配的第一个位置，然后跳出while循环，继续移动右边界，寻找在该左边界的条件下的匹配窗口。
                    left++;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

}
