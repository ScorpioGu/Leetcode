package array;

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
        //left[i]代表i位置的左边第一个小于heights[i]的坐标
        int[] left = new int[heights.length];
        //right[i]代表i位置右边第一个小于heights[i]的坐标
        int[] right = new int[heights.length];
        //边界情况
        left[0] = -1;
        right[right.length - 1] = right.length;
        for (int i = 1; i < left.length; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                //因为left[p]存储的是第一个小于heights[p]的坐标
                //利用这个特性，直接跳过大于heights[p]的坐标
                p = left[p];
            }
            //到这里，则p就是第一个小于heights[i]的坐标
            left[i] = p;
        }

        //这里一定要倒序循环，保证执行ｐ = right[p]，right[p]是已经初始化过的
        for (int i = right.length - 2; i >= 0; i--) {
            int p = i + 1;
            while (p <= right.length -1 && heights[p] >= heights[i]) {
                p = right[p];
            }
            right[i] = p;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new 直方图中最大矩形().largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
