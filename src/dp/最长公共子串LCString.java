package dp;

/**
 * @Desc TODO
 * @Author gcc
 * @Date 19-6-2 下午4:31
 **/
public class 最长公共子串LCString {
    public static String LCString(String s, String t) {
        // dp[i][j]表示以ｉ-1,j-1这两个字符结尾的子串的最长公共子串的长度
        // 那么最大长度的肯定在dp数组内，需要每计算出来一个比较一次
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        int max = 0;
        int end = 0;
        for (int i = 1; i <= s.length() ; i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if (dp[i][j] > max) {
                        end = i;
                        max = dp[i][j];
                    }
                }
            }
        }
        return s.substring(end - max, end);
    }
}
