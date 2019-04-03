package string;

/**
 * @Desc https://leetcode.com/problems/edit-distance/description/
 *
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

 * @Author gcc
 * @Date 18-10-29 上午9:51
 **/
public class 最少操作完成字符串转换 {
    /**
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return -1;
        }
        int len1 = word1.length(), len2 = word2.length();
        //res[i][j]记录word1的前i个字符转成word2的前j个字符所需要的步数

        //base的情况，res[0][k]，即0个字符转k个字符，需要insert k次
        //res[k][0],k个字符转0个字符，需要delete k次
        int[][] res = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len2; i++) {
            res[0][i] = i;
        }
        for (int i = 0; i <= len1; i++) {
            res[i][0] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    //如果第i个与第j个字符相等，那么是不需要额外操作的
                    res[i][j] = res[i - 1][j - 1];
                } else {
                    //res[i-1][j]对应删除操作，res[i][j-1]对应插入操作，res[i-1][j-1]对应置换操作
                    int dis = Math.min(Math.min(res[i - 1][j], res[i][j - 1]), res[i-1][j-1]);
                    res[i][j] = dis + 1;
                }
            }
        }
        return res[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(new 最少操作完成字符串转换().minDistance("horse", "ros"));

    }
}