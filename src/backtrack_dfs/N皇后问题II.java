package backtrack_dfs;

import java.util.ArrayList;

/**
 * @Desc https://leetcode.com/problems/n-queens-ii/description/
 * 这道题要返回的是解的个数
 * @Author gcc
 * @Date 18-10-22 下午10:44
 **/
public class N皇后问题II {
    public int totalNQueens(int n) {
        boolean[][] cur = new boolean[n][n];
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        dfs(cur, 0, res);
        return res.get(0);
    }

    private void dfs(boolean[][] board, int colIndex, ArrayList<Integer> res) {
        if(colIndex == board.length) {
            res.set(0, res.get(0) + 1);
            return;
        }

        for(int i = 0; i < board.length; i++) {
            if(validate(board, i, colIndex)) {
                board[i][colIndex] = true;
                dfs(board, colIndex + 1, res);
                board[i][colIndex] = false;
            }
        }
    }

    private boolean validate(boolean[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < y; j++) {
                if(board[i][j] && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }

        return true;
    }
}
