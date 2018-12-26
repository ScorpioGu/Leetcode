package design;

/**
 * @Desc TODO
 * @Author gcc
 * @Date 18-12-19 下午10:15
 **/
public class 求可变二维数组指定区间的元素和{
    private int[][] sums;
    private int[][] matrix;

    public 求可变二维数组指定区间的元素和(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        this.sums = new int[matrix.length+1][matrix[0].length+1];
        this.matrix = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        if (matrix == null) return;
        int adjust = val - matrix[row][col];
        matrix[row][col] = val;
        row ++;
        col ++;
        int i=row;
        while (i<sums.length) {
            int j=col;
            while (j<sums[i].length) {
                sums[i][j] += adjust;
                j += (j & -j);
            }
            i += (i & -i);
        }
    }

    private int sum(int row, int col) {
        row ++;
        col ++;
        int sum = 0;
        int i=row;
        while (i>0) {
            int j=col;
            while (j>0) {
                sum += sums[i][j];
                j -= (j & -j);
            }
            i -= (i & -i);
        }
        return sum;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (matrix == null) return 0;
        return sum(row2,col2) - sum(row2, col1-1) - sum(row1-1, col2) + sum(row1-1, col1-1);
    }
}
