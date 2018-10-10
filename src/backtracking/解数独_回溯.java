package backtracking;

/**
 * @Desc https://leetcode.com/problems/sudoku-solver/description/
 *       假设给定的board有唯一解
 * @Author gcc
 * @Date 18-10-10 上午11:19
 **/
public class 解数独_回溯 {
    public void solveSudoku(char[][] board) {
        //二维数组，第二维的长度暂时可以不指定
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }

    /**
     * 回溯
     * @param board
     * @return
     */
    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            } else {
                                //子状态不可行，则还原至上一个状态。然后换一个数继续试
                                board[i][j] = '.';
                            }
                        }
                    }
                    //在i，j坐标9个数都试过了，都不行，那么当前这个board是不可行的
                    return false;
                }
            }
        }
        //走到这，说明if(board[i][j] == '.')这个条件没有符合，当前的board已经全部填充好了
        return true;
    }

    //判断当board[i][j]填入c时，是否会与行，列，九宫阁产生冲突
    private boolean isValid(char[][] board, int i, int j, char c) {
        for (int k=0; k<9; k++) {
            if (board[i][k] == c) {
                return false;
            }
            if (board[k][j] == c) {
                return false;
            }
            if (board[3*(i/3) + k/3][3* (j/3) + k%3] == c) {
                return false;
            }
        }
        return true;
    }
}
