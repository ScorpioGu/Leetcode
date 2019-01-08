package dp;

import java.util.Arrays;

/**
 * @Desc https://leetcode.com/problems/maximal-rectangle/description/
 * Example:
 *
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * Output: 6
 * @Author gcc
 * @Date 18-11-1 上午10:12
 **/
public class 矩阵中的最大矩形 {
    /**
     * 与直方图中最大矩形那题类似，对每个元素，求其高度，左右边界。
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int[] left = new int[matrix[0].length];
        int[] right = new int[matrix[0].length];
        int[] height = new int[matrix[0].length];
        //right全部初始化为ｎ
        Arrays.fill(right, right.length);
        Arrays.fill(left, -1);
        for (int i = 0; i < matrix.length; i++) {
            //curLeft指向当前ｊ所在矩形的左边界，cur指向右边界
            int curLeft = 0, curRight = matrix[0].length;
            for (int j = 0; j < matrix[0].length; j++) {
                //更新height
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
                //更新left
                if (matrix[i][j] == '1') {
                    //这里隐含了高度的判断
                    left[j] = Math.max(curLeft, left[j]);
                } else {
                    //遇到0了，left[j]设为-1,更新curLeft
                    left[j] = -1;
                    curLeft = j;
                }
            }
            //对右边界的更新必须倒序
            for (int j = matrix[0].length-1; j >= 0 ; j--) {
                if (matrix[i][j] == '1') {
                    //这里隐含了高度的判断
                    right[j] = Math.min(curRight, right[j]);
                } else {
                    right[j] = matrix[0].length;
                    curRight = j;
                }
            }

            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, (right[j] - left[j] - 1) * height[j]);
            }
        }
        return max;
    }

}
