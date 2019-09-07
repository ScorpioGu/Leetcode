package design;

/**
 * @Desc https://www.cnblogs.com/grandyang/p/5467118.html
 * @Author gcc
 * @Date 19-6-12 下午6:57
 **/
public class 设计井字棋 {
    int[] col, row;
    // 对角线只有正反两条
    int diag1, diag2, n;
    public 设计井字棋(int n) {
        col = new int[n];
        row = new int[n];
        this.n = n;
    }

    /**
     * 放旗子的操作，i，j为坐标，player取值为1,2，代表下棋的选手
     * 如果这步棋了，没有赢家，返回0，否则返回赢的选手
     * @param i
     * @param j
     * @param player
     * @return
     */
    public int move(int i, int j, int player) {
        int add = player == 1 ? 1 : -1;
        col[i] += add;
        row[j] += add;
        diag1 += i == j ? add : 0;
        diag2 += (i + j + 1 == n) ? add : 0;
        return (Math.abs(col[i]) == n
                || Math.abs(col[j]) == n
                || Math.abs(diag1) == n
                || Math.abs(diag2) == n) ? player : 0;
    }
}
