package dp;

/**
 * @Desc https://leetcode.com/problems/range-sum-query-2d-immutable/
 * @Author gcc
 * @Date 18-12-19 下午4:28
 **/
public class 求不可变二维数组指定区间的元素和 {
    int[][] sums;
    public 求不可变二维数组指定区间的元素和(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return;
        }
        sums = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2+1][col1] + sums[row1][col1];
    }
}
