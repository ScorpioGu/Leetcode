package Math;

/**
 * @Desc https://www.cnblogs.com/grandyang/p/5282959.html
 * @Author gcc
 * @Date 18-12-19 下午10:51
 **/
public class 稀疏矩阵相乘 {
    /**
     * 矩阵相乘,i*k  k*j => i * j
     * C[i,j] = 求和(A[i][m] * B[m][j]), m从0到k-1
     * 为减少乘法运算,对A[i][m],B[m][j]进行判0
     * @param A
     * @param B
     * @return
     */
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            for (int k = 0; k < A[0].length; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < B.length; j++) {
                        if (B[k][j] != 0) {
                            res[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
        }
        return res;
    }
}
