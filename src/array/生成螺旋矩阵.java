package array;

/**
 * @Desc https://leetcode.com/problems/spiral-matrix-ii/description/
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * @Author gcc
 * @Date 18-10-23 下午10:50
 **/
public class 生成螺旋矩阵 {
    /**
     *
     * @param n 代表方阵的边长
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int rowBegin = 0, rowEnd = n - 1, colBegin = 0, colEnd = n - 1;
        int value = 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                //linklist.add(matrix[rowBegin][i]);
                res[rowBegin][i] = value++;
            }
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd; i++) {
                res[i][colEnd] = value++;
            }
            colEnd--;
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin ; i--) {
                    res[rowEnd][i] = value++;
                }
            }
            rowEnd--;
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    res[i][colBegin] = value++;
                }
            }
            colBegin++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] res = new 生成螺旋矩阵().generateMatrix(3);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.println(res[i][j]);
            }
        }
    }
}
