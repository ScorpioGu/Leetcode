package array;

/**
 * @Desc https://leetcode.com/problems/search-a-2d-matrix-ii/
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Example:
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * <p>
 * Given target = 20, return false.
 * @Author gcc
 * @Date 18-12-3 下午4:14
 **/
public class 在有序二维数组中查找元素II {
    /**
     * 这题如果常规地从左上角开始搜索的话,往下与往右都是增加的方向
     * 但是如果从坐下或者右上角搜索,则一个方向是增加,另一个方向减小.时间复杂度可见降为o(m+n)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int colLen = matrix.length, rowLen = matrix[0].length;
        int i = colLen - 1, j = 0;
        while (i >= 0 && j < rowLen) {
            if (target == matrix[i][j]) {
                return true;
            }
            if (matrix[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }
}
