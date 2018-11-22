package backtrack_dfs;

/**
 * @Desc https://leetcode.com/problems/number-of-islands/description/
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 * @Author gcc
 * @Date 18-11-22 下午2:18
 **/
public class 小岛个数 {
    /**
     * 和包围区域那道题比较像吧
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] board, int i, int j) {
        board[i][j] = '*';
        if (i + 1 >= 0 && i + 1 < board.length && board[i + 1][j] == '1') {
            dfs(board, i + 1, j);
        }
        if (i - 1 >= 0 && i - 1 < board.length && board[i - 1][j] == '1') {
            dfs(board, i - 1, j);
        }
        if (j + 1 >= 0 && j + 1 < board[0].length && board[i][j + 1] == '1') {
            dfs(board, i, j + 1);
        }
        if (j - 1 >= 0 && j - 1 < board[0].length && board[i][j - 1] == '1') {
            dfs(board, i, j - 1);
        }
    }
}
