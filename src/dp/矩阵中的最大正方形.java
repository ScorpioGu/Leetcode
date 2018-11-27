package dp;

/**
 * @Desc https://leetcode.com/problems/maximal-square/description/
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 * @Author gcc
 * @Date 18-11-26 下午3:54
 **/
public class 矩阵中的最大正方形 {
    /**
     * 因为要求正方形的面积,动态规划来递推面积是不太好做的.
     * 因为正方形的面积只与边长有关,所以用边长来做dp
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        //edgeLen[i][j]表示以matrix[i][j]为正方形右下角的正方形的最大边长
        int maxLen = 0;
        int[][] edgeLen = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    edgeLen[i][j] = matrix[i][j] - '0';
                } else if (matrix[i][j] == '1') {
                    edgeLen[i][j] = Math.min(Math.min(edgeLen[i - 1][j], edgeLen[i - 1][j - 1]), edgeLen[i][j - 1]) + 1;
                }
                maxLen = Math.max(maxLen, edgeLen[i][j]);
            }
        }
        return maxLen * maxLen;
    }
}
