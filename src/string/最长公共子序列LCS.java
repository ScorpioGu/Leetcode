package string;

/**
 * @Desc
 * 两个母串
 * cnblogs
 * belong
 * 比如序列bo, bg, lg在母串cnblogs与belong中都出现过并且出现顺序与母串保持一致，我们将其称为公共子序列
 * @Author gcc
 * @Date 19-4-3 下午9:18
 **/
public class 最长公共子序列LCS {
    public int LCS(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int c[][] = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    c[i][j] = 0;
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
