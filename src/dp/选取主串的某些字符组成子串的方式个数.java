package dp;

/**
 * @Desc https://leetcode.com/problems/distinct-subsequences/description/
 * Example 1:
 *
 * Input: S = "rabbbit", T = "rabbit"
 * Output: 3
 * Explanation:
 *
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * (The caret symbol ^ means the chosen letters)
 * rabbit
 *
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * @Author gcc
 * @Date 18-11-6 上午10:10
 **/
public class 选取主串的某些字符组成子串的方式个数 {
    public int numDistinct(String s, String t) {
        //nums[i][j]表示s的前i个字符与t的前j个字符匹配的路径个数,i一定是大于等于j的
        int[][] nums = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length() ; i++) {
            for (int j = 0; j <= t.length(); j++) {
                //空串是任何字符串的子串
                if (j == 0) {
                    nums[i][j] = 1;
                } else if (i == 0) {
                    //空串的子串只有空串一个
                    nums[i][j] = 0;
                } else {
                    if (s.charAt(i-1) == t.charAt(j-1)) {
                        //t.charAt(j)是必选的,s.charAt(i)则是可选的
                        //nums[i-1][j-1]这个来源代表选上s.charAt(i),nums[i-1][j]代表不选s.charAt(i)
                        nums[i][j] = nums[i-1][j-1] + nums[i-1][j];
                    } else {
                        //不相等的情况则必然不能选上s.charAt(i)
                        nums[i][j] = nums[i-1][j];
                    }
                }
            }
        }
        return nums[s.length()][t.length()];
    }
}
