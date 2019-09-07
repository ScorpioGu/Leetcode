package palindrome;

/**
 * @Desc https://leetcode.com/problems/palindromic-substrings/
 * @Author gcc
 * @Date 19-6-10 下午10:00
 **/
public class 子串为回文的个数 {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] pal = new boolean[n][n];
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j ; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || pal[i + 1][j - 1])) {
                    pal[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
}
