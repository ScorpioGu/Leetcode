package stack_queue;

import java.util.Stack;

/**
 * @Desc https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 * Example:
 *
 * Input: [2,1,5,6,2,3]
 * Output: 10
 * @Author gcc
 * @Date 18-10-31 下午10:01
 **/
public class 直方图中最大矩形 {
    /**
     * 对坐标ｉ来说，往左找到第一个比其高度小的坐标left，往右找到第一个比其高度小的坐标right
     * 则其面积为height[i] * (right - left - 1)
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        // 对于每一height[i],需要找到左边第一个比它小的索引leftIndex,第一个比它小的右边的索引rightIndex
        // 如果leftIndex存在,则以height[i]为高度的矩阵的面积为height[i] * (rightIndex - leftIndex - 1)
        // 若leftINdex不存在,则以height[i]为高度的矩阵的面积为height[i] * (rightIndex)

        int len = heights.length;
        // stack存储单调增序列的索引（栈底到栈顶单调增）,对于每个栈的元素,它在栈中的下一个元素就是它的leftIndex
        // 遍历heights,遇到比栈顶元素大的就入栈,否则就计算面积,此时遍历的索引i,就是栈顶元素的rightIndex
        Stack<Integer> stack = new Stack();

        int max = 0;
        // 注意要遍历到i = len,不然最后一个元素没法算了
        for (int i = 0; i <= len; i++) {
            // 在i == len时，设h=0，这个小技巧，
            int h = (i == len ? 0 : heights[i]);

            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int cur = stack.pop();
                int r = i;
                int l = stack.isEmpty() ? -1 : stack.peek();
                max = Math.max(max, heights[cur] * (r - l - 1));
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new 直方图中最大矩形().largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
