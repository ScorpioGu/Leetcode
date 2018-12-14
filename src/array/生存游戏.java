package array;

/**
 * @Desc https://leetcode.com/problems/game-of-life/
 * 题目描述见链接
 * @Author gcc
 * @Date 18-12-14 下午12:58
 **/
public class 生存游戏 {
    /**
     * 因为要求空间复杂度为in-place,所以用两个位来存储当前状态 xy,y表示当前状态,x表示下个状态
     * 0->00 表示当前状态为0,下个状态为0.
     * 这样当board[i][j]被修改之后,仍然保留先前的状态,用board[i][j] & 1获取.
     * 在全部元素更新完毕之后,所有的第一状态均不再需要,保留第二状态即可,即将所有元素右移1位
     * @param board
     */
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = getLives(i, j, board);

                //因为board的初始值是00,01,即下一个状态默认是dead,我们仅需要考虑什么时候
                //下个状态为live即可.
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2;
                } else if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                    board[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int getLives(int x, int y, int[][] board) {
        int lives = 0;
        for (int i = Math.max(0, x - 1); i <= Math.min(board.length- 1, x + 1); i++) {
            for (int j = Math.max(0, y - 1); j <= Math.min(board[0].length - 1, y + 1); j++) {
                lives += board[i][j] & 1;
            }
        }
        //记得要减去自己
        lives -= board[x][y] & 1;
        return lives;
    }
}
