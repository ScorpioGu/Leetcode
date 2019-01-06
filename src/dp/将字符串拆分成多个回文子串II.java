package dp;

/**
 * @Desc https://leetcode.com/problems/palindrome-partitioning-ii/description/
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * @Author gcc
 * @Date 18-11-15 下午5:27
 **/
public class 将字符串拆分成多个回文子串II {
    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        boolean[][] isPal = new boolean[s.length()][s.length()];
        //cut[i]代表[0, i]这段字符串(共i+1个字符)最小需要切多少下
        int[] cut = new int[s.length()];

        for (int j = 0; j < s.length(); j++) {
            //初始化为每个单独的字符切一刀,cut[j]代表j+1个字符,最坏情况是j刀
            cut[j] = j;
            for (int i = 0; i <= j ; i++) {
                //对于[0, j]这段字符,如果存在i,使得[i, j]为回文字符串
                //则cut[j] = math.min(cut[j], cut[i - 1] + 1)
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                    if (i == 0) {
                        //如果i == 0,则一整个字符串就是回文的不用切
                        cut[j] = 0;
                    } else {
                        cut[j] = Math.min(cut[j], cut[i - 1] + 1);
                    }
                }
            }
        }
        return cut[cut.length - 1];
    }
}
