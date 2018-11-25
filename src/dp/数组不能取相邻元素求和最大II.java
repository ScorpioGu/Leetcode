package dp;

/**
 * @Desc https://leetcode.com/problems/house-robber-ii/description/
 *
 * 与第一题相比,多了一个条件,数组中第一个元素与最后一次元素算相邻
 * Example 1:
 *
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 *              because they are adjacent houses.
 * Example 2:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * @Author gcc
 * @Date 18-11-25 下午5:34
 **/
public class 数组不能取相邻元素求和最大II {
    /**
     * 既然首尾不能相邻,那么我就分两段来做吧,第一段有头没尾,第二段没头有尾
     * 去两段中的较大值
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int maxFirst = nums[0];
        int maxSecond = Math.max(nums[0], nums[1]);
        for (int i=2; i<nums.length - 1; i++) {
            int temp = maxSecond;
            maxSecond = Math.max(maxFirst + nums[i], maxSecond);
            maxFirst = temp;
        }
        int max1 = maxSecond;

        maxFirst = nums[1];
        maxSecond = Math.max(nums[1], nums[2]);
        for (int i = 3; i <nums.length ; i++) {
            int temp = maxSecond;
            maxSecond = Math.max(maxFirst + nums[i], maxSecond);
            maxFirst = temp;
        }
        int max2 = maxSecond;

        return Math.max(max1, max2);
    }
}
