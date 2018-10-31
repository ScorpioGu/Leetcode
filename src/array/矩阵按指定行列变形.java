package array;

/**
 * https://leetcode.com/problems/reshape-the-matrix/description/
 * Input:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 * Output:
 * [[1,2,3,4]]
 *
 * Example 2:
 * Input:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 2, c = 4
 * Output:
 * [[1,2],
 *  [3,4]]
 *  Explanation:
 * There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 */
public class 矩阵按指定行列变形 {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums == null || nums.length == 0) {
            return null;

        }
        if(r * c != nums.length * nums[0].length) {
            return nums;
        }
        int[][] rtn = new int[r][c];
        int m = nums.length;
        int n = nums[0].length;
        for(int i=0; i<r*c; i++) {
        	rtn[i/c][i%c] = nums[i/n][i%n];
        }
        return rtn;
    }
}
