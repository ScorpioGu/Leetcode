package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Desc 和第一题的区别在于,所给的str不再以空格作为分隔符,需要自己去寻找在哪里分割字符合适
 * @Author gcc
 * @Date 18-12-15 上午9:56
 **/
public class 判断字符串与所给的模式是否匹配II {
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return recursion(pattern, str, 0, 0, map, set);
    }

    /**
     *
     * @param pattern
     * @param str
     * @param i 指向pattern的指针
     * @param j 指向str的指针
     * @param map 存储模式字符与字符串的映射关系,必须是一对一映射
     * @param set 存储已经存在了映射关系的字符串,保证映射关系一对一
     */
    private boolean recursion(String pattern, String str, int i, int j, Map<Character, String> map, Set<String> set) {
        if (i == pattern.length() && j == str.length()) {
            return true;
        }
        if (i == pattern.length() || j == str.length()) {
            return false;
        }
        char c = pattern.charAt(i);
        if (map.containsKey(c)) {
            String s = map.get(c);
            if (!str.startsWith(s, j)) {
                return false;
            }
            return recursion(pattern, str, i + 1, j + s.length(), map, set);
        } else {
            for (int k = j; k < str.length(); k++) {
                String s = str.substring(j, k + 1);
                if (set.contains(s)) {
                    continue;
                }
                map.put(c, s);
                set.add(s);
                if (recursion(pattern, str, i + 1, j + s.length(), map, set)) {
                    return true;
                }
                //如果此次分割失败了,将map,set还原试试下一种分割
                map.remove(c);
                set.remove(s);
            }
        }
        return false;
    }
}
