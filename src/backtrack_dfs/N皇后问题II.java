package backtrack_dfs;

/**
 * @Desc https://leetcode.com/problems/n-queens-ii/description/
 * 这道题要返回的是解的个数
 * @Author gcc
 * @Date 18-10-22 下午10:44
 **/
public class N皇后问题II {
    private int res;

    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;

    public int totalNQueens(int n) {
        if (n == 0)
            return res;
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        putQueen(n, 0);

        return res;
    }

    private void putQueen(int n, int index) {
        if (index == n) {
            res++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;

                putQueen(n, index + 1);

                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
            }
        }
    }
}
