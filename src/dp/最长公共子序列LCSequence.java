package dp;

/**
 * @Desc
 * 两个母串
 * cnblogs
 * belong
 * 比如序列bo, bg, lg在母串cnblogs与belong中都出现过并且出现顺序与母串保持一致，我们将其称为公共子序列
 * @Author gcc
 * @Date 19-4-3 下午9:18
 **/
public class 最长公共子序列LCSequence {
    public int LCS(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        // c[i][j]代表两个字符串的前i个字符和前j个字符，的最长公共子序列的长度，可以不包含i-1，j-1两个字符
        int c[][] = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    c[i][j] = 0;
                // 一般这种问题，都要分成两字符串最后一个字符是否相等来讨论
                // 把子问题都当成已知量
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
                }
            }
        }
        return c[len1][len2];
    }
}
