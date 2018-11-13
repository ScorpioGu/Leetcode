package backtrack_dfs;

/**
 * @Desc https://leetcode.com/problems/surrounded-regions/description/
 * EXample:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * @Author gcc
 * @Date 18-11-13 下午1:52
 **/
public class 包围区域 {
    /**
     * 对处在边界出的o和其所有邻居的o,先将其变成任意一个其他字符,比如'*'(使用dfs向四周搜索)
     * 然后将所有剩下的o变成'X'
     * 再将所有的'*'变成'o'
     *
     * @param board
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
                    if (board[i][j] == 'O') {
                        dfs(board, i, j);
                    }
                }
            }
        }

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        board[i][j] = '*';
        if (i + 1 >= 0 && i + 1 < board.length && board[i + 1][j] == 'O') {
            dfs(board, i + 1, j);
        }
        if (i - 1 >= 0 && i - 1 < board.length && board[i - 1][j] == 'O') {
            dfs(board, i - 1, j);
        }
        if (j + 1 >= 0 && j + 1 < board[0].length && board[i][j + 1] == 'O') {
            dfs(board, i, j + 1);
        }
        if (j - 1 >= 0 && j - 1 < board[0].length && board[i][j - 1] == 'O') {
            dfs(board, i, j - 1);
        }
    }
}
