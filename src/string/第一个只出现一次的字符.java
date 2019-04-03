package string;

import java.util.*;

/**
 * @Desc https://leetcode.com/problems/first-unique-character-in-a-string/
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 *
 * @Author gcc
 * @Date 19-1-14 上午9:48
 **/
public class 第一个只出现一次的字符 {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        // map记录只出现过一次的字符并记录字符索引
        // 为什么要用linkedhashmap,因为hashmap不能保证数据插入与取出的有序性
        // 而linkedhashmap底层是双向链表，保证了有序性
        // 因为是要返回的索引值，所以用map存一下
        Map<Character, Integer> map = new LinkedHashMap<>();

        // set记录所有出现过的字符，用set是降低了时间复杂度，结合set才能够保证
        // 遍历完之后map中的元素只出现一次。如果只用map，对于出现奇数次的元素，第一次添加到map，第二次出现再将其从map中删除，第三次遇到又添加到了map中
        // 如果不用set，那么map需要保存的value就是该字符出现的次数，由于没有保存索引信息，所以还需要对字符数组再进行一次遍历，增加了时间复杂度。

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            // 如果一个元素在set中存在了,这是一个重复的元素
            // 如果这是第一次重复,需要将这个字符从map中删除,如果是第n(n>1)次重复,这个字符在第一次已经从map中删掉了,不用去管
            if (set.contains(s.charAt(i))) {
                if (map.containsKey(s.charAt(i))) {
                    map.remove(s.charAt(i));
                }
            } else {
                set.add(s.charAt(i));
                map.put(s.charAt(i), i);
            }

        }
        //利用linkedHashMap的有序性
        return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
    }
}
