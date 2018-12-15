package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc https://leetcode.com/problems/word-pattern/
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Example 1:
 *
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 *
 * @Author gcc
 * @Date 18-12-15 上午9:33
 **/
public class 判断字符串与所给的模式是否匹配 {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null || pattern.length() != str.split(" ").length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        String[] ss = str.split(" ");
        char[] cs = pattern.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (map.containsKey(cs[i])) {
                if (!map.get(cs[i]).equals(ss[i])) {
                    return false;
                }
            } else if (map.containsValue(ss[i])){
                return false;
            } else {
                map.put(cs[i], ss[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new 判断字符串与所给的模式是否匹配().wordPattern("abba", "dog dog dog dog"));
    }
}
