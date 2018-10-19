package greedy;

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
        //valid[i][j] 表示s的前i个字符和p的前j个字符是否匹配
        boolean valid[][] = new boolean[s.length() + 1][p.length() + 1];
        valid[0][0] = true;
        for (int j = 0; j < p.length(); j++) {
            if (valid[0][j] && p.charAt(j) == '*') {
                valid[0][j+1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
                    valid[i+1][j+1] = valid[i][j];
                } else if (p.charAt(j) == '*') {
                    valid[i + 1][j + 1] = valid[i][j + 1] || valid[i+1][j];
                }

            }
        }
        return valid[s.length()][p.length()];
    }

    public static void main(String[] args) {
        System.out.println(new 通配符匹配().isMatch("adceb", "*a*b"));

    }
}
