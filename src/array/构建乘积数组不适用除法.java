package array;

/**
 * @Desc 给定一个数组A[0, 1, ..., n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * @Author gcc
 * @Date 19-3-22 下午4:48
 **/
public class 构建乘积数组不适用除法 {
    /**
     * 将res想象成一个二维方阵，对角线上元素为1
     * B[i] = A[0]*A[1]*...*A[i-1] *1* A[i+1]*...*A[n-1] = left[i] * right[i]
     * 其中left[i] = left[i-1] * A[i-1], right[i] = right[i+1] *A[i + 1],left[0] = 1, right[len - 1] = 1
     *
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        if (A == null || A.length < 2) {
            return A;
        }
        int len = A.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * A[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * A[i + 1];
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
