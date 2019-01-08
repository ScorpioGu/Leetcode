package array;

import java.util.TreeSet;

/**
 * @Desc https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
 * Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.
 *
 * Example:
 *
 * Input: matrix = [[1,0,1],[0,-2,3]], k = 2
 * Output: 2
 * Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
 *              and 2 is the max number no larger than k (k = 2).
 * Note:
 *
 * The rectangle inside the matrix must have an area > 0.
 * What if the number of rows is much larger than the number of columns?
 * @Author gcc
 * @Date 19-1-8 上午10:38
 **/
public class 矩阵中和最接近k的子矩阵 {
    /**
     * 二维数据,先考虑一维的情况,用sum[i]表示[0,i)的元素和,同时使用TreeSet存储之前的sum[0],...sum[i-1]
     * 那么对于每个i,我们需要在[0,i-1]中找一个j,使得sum[i] - sum[j]最接近k,即sum[j]最接近sum[i]-k,可以通过
     * TreeSet.ceiling(sum[i] - k)找到那个sum[j].
     *
     * 而二维的情况下,sum[k] = array[0] + array[1] + ...　＋　array[k-1] 其中array[k]表示第k列,第i行到第j行的元素和()
     *
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = Math.min(matrix.length, matrix[0].length);
        int n = Math.max(matrix.length, matrix[0].length);
        boolean colIsBigger = matrix[0].length > matrix.length ? true : false;
        int res = Integer.MIN_VALUE;
        //想象一下第i行是底下一根线,j最开始和i重合,然后慢慢往上升,而l是一根竖线,一开始在最左边,然后慢慢往右
        //这三根线组成的窗口到了最大的时候,i这根线再往下移动一个单位,重复上述过程
        for (int i = 0; i < m; i++) {
            //假如列大于行,singleLine[l]表示这一列,从第j到第i行的元素之和
            //每当j变小,singleLine[l]在原值的基础上累加,所以用一个一维数据即可
            int[] singleLine = new int[n];
            for (int j = i; j >=0 ; j--) {
                TreeSet<Integer> t = new TreeSet();
                //添加一个0,是为了k和sum恰好相等的情况
                t.add(0);
                int sum = 0;
                for (int l = 0; l < n; l++) {
                    singleLine[l] += colIsBigger ? matrix[j][l] : matrix[l][j];
                    sum += singleLine[l];
                    Integer diff = t.ceiling(sum - k);
                    if (diff != null) {
                        res = Math.max(res, sum - diff);
                    }
                    t.add(sum);
                }
            }
        }
        return res;
    }
}
