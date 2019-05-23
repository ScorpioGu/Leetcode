package backtrack_dfs_recursion;

import java.util.*;

/**
 * @Desc https://leetcode.com/problems/n-queens/description/
 * 在n×n的矩阵中放8皇后，使其不能相互攻击。相互攻击指的是，同一横线，竖线，斜线上有其它皇后。
 * 用q代表皇后,.代表空
 * @Author gcc
 * @Date 18-10-22 下午9:28
 **/
public class N皇后问题 {
    private ArrayList<String[]> res;

    //列 col[i]为true代表第i列不可以再放皇后
    private boolean[] col;
    // dia1[i] = true代表x+y=i这条对角线上不可以放皇后
    private boolean[] dia1;
    // dia1[i] = true代表x-y=i这条对角线上不可以放皇后,由于x-y可能会小于0，整体+n-1,保证>=0
    private boolean[] dia2;

    public ArrayList<String[]> solveNQueens(int n) {
        res = new ArrayList<String[]>();
        if (n == 0)
            return res;
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        putQueen(n, 0, new ArrayList<Integer>());
        return res;
    }

    //尝试在一个n皇后问题中，摆放第index行的皇后位置,row存放的是每一行皇后存放的下标
    private void putQueen(int n, int index, ArrayList<Integer> row) {
        if (index == n) {
            res.add(generateBoard(n, row));
            return;
        }

        for (int i = 0; i < n; i++) {
            //判断能否将第index行的皇后摆放在第i列
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;

                row.add(i);
                putQueen(n, index + 1, row);
                row.remove(row.size() - 1);

                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
            }
        }
    }

    private String[] generateBoard(int n, ArrayList<Integer> row) {
        String[] list = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == row.get(i))
                    s.append("Q");
                else
                    s.append(".");
            }
            list[i] = s.toString();
        }
        return list;
    }
}
