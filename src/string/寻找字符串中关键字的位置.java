package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
 * 寻找字符串中关键词的位置，必须所有关键字连续出现，顺序无所谓。所有关键词的长度相同
 * Input:
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * Output: [0,9]
 *
 * @Author gcc
 */


public class 寻找字符串中关键字的位置 {
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return null;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            }
        }
        int wl = words[0].length();
        //这个for循环是选择不同的起点
        for (int i = 0; i < wl; i++) {
            int left = i, count = 0;
            HashMap<String, Integer> curMap = new HashMap<>();
            //因为是单词匹配，每次循环跳跃的长度是wl
            for (int j = i; j < s.length() - wl; j += wl) {
                String str = s.substring(j, j + wl);
                if (map.containsKey(str)) {
                    if (curMap.containsKey(str)) {
                        curMap.put(str, curMap.getOrDefault(str, 0) + 1);
                    }

                    if (curMap.get(str) <= map.get(str)) {
                        count++;
                    } else {
                        while (curMap.get(str) > map.get(str)) {
                            String temp = s.substring(left, left + wl);
                            if (curMap.containsKey(temp)) {
                                curMap.put(temp, curMap.get(temp) - 1);
                                if (curMap.get(temp) < map.get(temp)) {
                                    count--;
                                }
                            }
                            left += wl;
                        }
                    }

                    if (count == words.length) {
                        res.add(left);
                        String temp = s.substring(left, left + wl);
                        if (curMap.containsKey(temp)) {
                            curMap.put(temp, curMap.get(temp) - 1);
                        }
                        count--;
                        left += wl;
                    }
                } else {
                    curMap.clear();
                    count = 0;
                    left += wl;
                }

            }
        }
        return res;
    }
}
