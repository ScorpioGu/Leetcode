package string;

/**
 * @Desc https://leetcode.com/problems/wildcard-matching/description/
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 * @Author gcc
 * @Date 18-10-17 下午9:19
 **/
public class 通配符匹配 {
    public boolean isMatch(String s, String p) {
        boolean[][] valid = new boolean[s.length() + 1][p.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                if (i == 0 && j == 0) {
                    valid[i][j] = true;
                } else if (j == 0) {
                    valid[i][j] = false;
                } else if (i == 0) {
                    // s是空串，p全*的情况
                    valid[i][j] = valid[i][j-1] && (p.charAt(j-1) == '*');
                } else {
                    if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                        valid[i][j] = valid[i-1][j-1];
                    } else if (p.charAt(j-1) == '*'){
                        // 分别对应匹配0，多个,匹配1个的情况包含在多个里面
                        valid[i][j] = valid[i][j-1] || valid[i-1][j];
                    }
                }
            }
        }
        return valid[s.length()][p.length()];
    }
}
