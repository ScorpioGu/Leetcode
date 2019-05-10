package dp;
//https://leetcode.com/problems/regular-expression-matching/description/

//p是pattern，.代表一个任何的字符，*代表0个或多个前一个字符
//暴力法不好做阿，因为*能表示的情况太多了，也许当*为1个的时候不行，为0个的时候就行了，时间复杂度o（n）应该作不来

//考虑用动态规划，那种二维矩阵

public class 判断字符串是否匹配所给的正则表达式 {
    public boolean isMatch(String s, String p) {
        boolean[][] valid = new boolean[s.length() + 1][p.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                if (i == 0 && j == 0) {
                    valid[i][j] = true;
                } else if (i == 0) {
                    // "" 与 "*"算什么，算false，因此j需要>=2
                    if (j > 1)
                        valid[i][j] = valid[i][j-2] && (p.charAt(j-1) == '*');
                } else if (j == 0) {
                    valid[i][j] = false;
                } else {
                    if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                        valid[i][j] = valid[i-1][j-1];
                    } else if (p.charAt(j-1) == '*') {
                        if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                            // 这种情况要想匹配上只能是*算作0个将前一个字符删了
                            valid[i][j] = valid[i][j-2];
                        } else {
                            // 对应0个与多个，1个包含在多个的情况里
                            valid[i][j] = valid[i][j-2] || valid[i-1][j];
                        }
                    }
                }
            }
        }
        return valid[s.length()][p.length()];
    }
}
