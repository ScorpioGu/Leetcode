package binarySearch;

/**
 * @Desc https://leetcode.com/problems/search-a-2d-matrix/description/
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * @Author gcc
 * @Date 18-10-29 上午11:31
 **/
public class 有序二维数组中查找元素 {
    /**
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int colLen = matrix.length, rowLen = matrix[0].length;
        int begin = 0, end = colLen * rowLen - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (matrix[mid / rowLen][mid % rowLen] == target) {
                return true;
            }
            if (matrix[mid / rowLen][mid % rowLen] < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new 有序二维数组中查找元素().searchMatrix(new int[][]{{1}, {3}, {5}}, 3));
    }
}
