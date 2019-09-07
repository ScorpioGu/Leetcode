package slide_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Desc https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 * @Author gcc
 * @Date 19-6-9 下午6:03
 **/

public class 寻找字符串中的所有anagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        int l = 0, r = 0;
        while (r < s.length()) {
            char rchar = s.charAt(r);
            if (map.containsKey(rchar)) {
                map.put(rchar, map.get(rchar) - 1);
                if (map.get(rchar) == 0) {
                    counter--;
                }
            }

            while (counter == 0) {
                char lchar = s.charAt(l);
                if (map.containsKey(lchar)) {
                    map.put(lchar, map.get(lchar) + 1);
                    if (map.get(lchar) > 0) {
                        counter++;
                    }
                }
                if (r - l + 1 == p.length()) {
                    res.add(l);
                }
                l++;
            }
            r++;
        }
        return res;
    }
}
