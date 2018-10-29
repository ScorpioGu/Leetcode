package array;

/**
 * @Desc https://leetcode.com/problems/set-matrix-zeroes/description/
 * Example 1:
 *
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 * do it in-place
 *
 * @Author gcc
 * @Date 18-10-29 上午10:32
 **/
public class 矩阵0所在行列全置0 {
    /**
     * 这里最大的问题就是我们遇到0的时候不能直接把矩阵的行列在当前矩阵直接置0，否则后面还没访问到的会被当成原来是0，最后会把很多不该置0的行列都置0了。
     * 一个直接的想法是备份一个矩阵，然后在备份矩阵上判断，在原矩阵上置0，这样当然是可以的，不过空间复杂度是O(m*n)，不是很理想。
     * 上面的方法如何优化呢？我们看到其实判断某一项是不是0只要看它对应的行或者列应不应该置0就可以，所以我们可以维护一个行和列的布尔数组，
     * 然后扫描一遍矩阵记录那一行或者列是不是应该置0即可这种方法的空间复杂度是O(m+n)。
     * 其实还可以再优化，我们考虑使用第一行和第一列来记录上面所说的行和列的置0情况，这里问题是那么第一行和第一列自己怎么办？想要记录它们自己是否要置0，
     * 只需要两个变量（一个是第一行，一个是第一列）就可以了,这样的做法只需要两个额外变量，所以空间复杂度是O(1)。
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        //这两个变量用来判断第0行与第0列是否要全部置0
        boolean isCol0 = false, isRow0 = false;

        int colLen = matrix.length, rowLen = matrix[0].length;
        for (int i = 0; i < colLen; i++) {
            if (matrix[i][0] == 0) {
                isRow0 = true;
                break;
            }
        }

        for (int i = 0; i < rowLen; i++) {
            if (matrix[0][i] == 0) {
                isCol0 = true;
                break;
            }
        }

        //用第一行与第一列来判断某一行和某一列是否应该全部置0,第第一行第一列开始判断
        //若matrix[0][i],代表第i列应该全部设为0，matrix[i][0]代表第i行应该全部设为0
        for (int i = 1; i < colLen; i++) {
            for (int j = 1; j < rowLen; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < colLen; i++) {
            for (int j = 1; j < rowLen; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(isCol0) {
            for(int j = 0; j < rowLen; j++) {
                matrix[0][j] = 0;
            }
        }

        if(isRow0) {
            for(int i = 0; i < colLen; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
