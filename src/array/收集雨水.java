package array;

/**
 * @Desc https://leetcode.com/problems/trapping-rain-water/description/
 * Given n non-negative integers representing an elevation map where
 * the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 * 本题同蓄水池那题不同，不要陷入长*宽的思维做法中。这道题的并不是求最优解，并不是dp的做法。既然起初总共收集的雨水，
 * 那么我们就看看每个坐标能够收集的水量。
 * 怎么才能够蓄水？自然两边高，中间低，水就能收集到。那么考虑先找到一个最高的（只需要找到下标即可，高度具体是不少不用考虑，
 * 因为蓄水量只与短的那一边有关，木桶效应）。
 * 随后两个指针往中间靠拢，
 * 同时维护左最高maxleft与右最高maxight，那么如果当前高度小于maxLeft或者maxRight,则可以收集的雨水为maxLeft（maxight） - height【i】
 * 求和即可。
 *
 * 双指针
 * @Author gcc
 * @Date 18-10-12 上午9:46
 **/
public class 收集雨水 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int sum = 0;
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[maxIndex] < height[i]) {
                maxIndex = i;
            }
        }
        int maxLeft = height[0];
        for (int i = 1; i<maxIndex; i++) {
            if (height[i] < maxLeft) {
                sum += maxLeft - height[i];
            } else {
                maxLeft = height[i];
            }
        }
        int maxRight = height[height.length-1];
        for (int i = height.length-2; i > maxIndex ; i--) {
            if (height[i] < maxRight) {
                sum += maxRight - height[i];
            } else {
                maxRight = height[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new 收集雨水().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
