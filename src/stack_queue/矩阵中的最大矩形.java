package stack_queue;

import java.util.Stack;

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
        int rlen = matrix.length;
        int clen = matrix[0].length;
        // heights[i]记录i这个竖着有多少个连续1,就是这个位置的高度,这个数组的长度为clen+1
        // 其中heights[clen] = 0,等效一下方便计算
        int[] heights = new int[clen + 1];
        heights[clen] = 0;

        for (int i = 0; i < rlen; i++) {
            Stack<Integer> stack = new Stack();
            for (int j = 0; j <= clen; j++) {
                // 更新heights
                if (j < clen) {
                    if (matrix[i][j] == '0') {
                        heights[j] = 0;
                    } else {
                        heights[j]++;
                    }
                }

                if (stack.isEmpty() || heights[j] >= heights[stack.peek()]) {
                    stack.push(j);
                } else {
                    while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                        int height = heights[stack.pop()];
                        max = Math.max(max, height * (stack.isEmpty() ? j : j - 1 - stack.peek()));
                    }
                    stack.push(j);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] cs = {{'1'}};
        System.out.println(new 矩阵中的最大矩形().maximalRectangle(cs));
    }

}
