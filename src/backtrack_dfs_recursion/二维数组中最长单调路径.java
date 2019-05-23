package backtrack_dfs_recursion;

/**
 * @Desc https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 * Given an integer matrix, find the length of the longest increasing path.
 *
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 *
 * Example 1:
 *
 * Input: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * @Author gcc
 * @Date 19-1-3 下午9:09
 **/
public class 二维数组中最长单调路径 {
    public static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int max = 1;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int res = dfs(matrix, i, j, m, n, cache);
                max = Math.max(max, res);
            }
        }
        return max;
    }

    /**
     * 对坐标为i,j的点进行dfs,因为cache
     * @param matrix
     * @param i
     * @param j
     * @param cache
     * @return
     */
    private int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        int max = 1;
        for (int[] dir : dirs) {
            int row = i + dir[0], col = j + dir[1];
            if (row >= 0 && row < m && col >= 0 && col < n && matrix[row][col] > matrix[i][j])
                max = Math.max(max, 1 + dfs(matrix, row, col, m, n, cache));
        }
        cache[i][j] = max;
        return max;
    }
}
