package backtrack_dfs_recursion;

import java.util.*;

/**
 * @Desc https://leetcode.com/problems/restore-ip-addresses/description/
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * Example:
 *
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 * @Author gcc
 * @Date 18-11-2 上午11:34
 **/
public class 还原ip地址 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        Deque<String> cur = new LinkedList<>();
        if (s == null || s.length() < 4) {
            return res;
        }
        backTrack(res, cur, s, 0);
        return res;
    }

    private void backTrack(List<String> res, Deque<String> cur, String s, int index) {
        if (cur.size() == 4 && index == s.length()) {
            Queue<String> curs = new LinkedList<>(cur);
            StringBuilder sb = new StringBuilder();
            while (curs.size() > 0) {
                sb.append(curs.poll()).append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        } else if (index == s.length()) {
            return;
        } else if (cur.size() >= 4) {
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (index <= s.length() - i) {
                String segment = s.substring(index, index + i);
                int value = Integer.parseInt(segment);
                if (value >= 256 || (segment.startsWith("0") && segment.length() > 1)) {
                    return;
                } else {
                    cur.add(segment);
                    backTrack(res, cur, s, index + i);
                    //cur.remove(cur.size() - 1);
                    cur.removeLast();
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> res = new 还原ip地址().restoreIpAddresses("0000");
        for (String s : res) {
            System.out.println(s);
        }
    }
}
