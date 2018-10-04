package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
//寻找字符串中关键词的位置，必须所有关键字连续出现，顺序无所谓。所有关键词的长度相同
//https://blog.csdn.net/linhuanmars/article/details/20342851

public class 寻找字符串中关键字的位置 {
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return null;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }
        int wl = words[0].length();
        for (int i = 0; i < wl; i++) {
            int left = i, count = 0;
            HashMap<String, Integer> curMap = new HashMap<>();
            for (int j = i; j < s.length() - wl; j += wl) {
                String str = s.substring(j, j + wl);
                if (map.containsKey(str)) {
                    if (curMap.containsKey(str)) {
                        curMap.put(str, curMap.get(str) + 1);
                    } else {
                        curMap.put(str, 1);
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
