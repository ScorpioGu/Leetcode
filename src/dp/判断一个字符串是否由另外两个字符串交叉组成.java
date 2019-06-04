package dp;

/**
 * @Desc https://leetcode.com/problems/interleaving-string/description/
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * Example 1:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Example 2:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * @Author gcc
 * @Date 18-11-2 下午8:30
 **/
public class 判断一个字符串是否由另外两个字符串交叉组成 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        //isValid[i][j]代表s1的前i个字符与s2的前j个字符可以交叉组成s3的前i+j个字符
        //使用这个二维数组保存之前计算的结果,否则会 带来冗余计算
        boolean[][] isValid = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    isValid[i][j] = true;
                } else if (i == 0) {
                    isValid[i][j] = (s2.charAt(j - 1) == s3.charAt(i + j - 1)) && isValid[i][j - 1];
                } else if (j == 0) {
                    isValid[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1)) && isValid[i - 1][j];
                } else {
                    isValid[i][j] = (s2.charAt(j - 1) == s3.charAt(i + j - 1)) && isValid[i][j - 1]
                            || (s1.charAt(i - 1) == s3.charAt(i + j - 1)) && isValid[i - 1][j];
                }
            }
        }
        return isValid[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new 判断一个字符串是否由另外两个字符串交叉组成().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
