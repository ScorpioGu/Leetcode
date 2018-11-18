package dp;

/**
 * @Desc https://leetcode.com/problems/maximum-product-subarray/description/
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * @Author gcc
 * @Date 18-11-18 下午1:55
 **/
public class 数组中乘积最大的子数组 {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //记录包含当前元素的局部最大值与最小值,记录最小值是为当遇到当前元素值小于0时,则下一个最大值可能是是负值乘上之前的最小值
        int lmax = nums[0];
        int lmin = nums[0];
        //因为要求最少包含一个元素,所以global不要初始化为0,初始化为第一个元素的值好了
        int global = nums[0];
        for (int i=1; i<nums.length; i++) {
            //当元素小于0,交换max与min,简化操作
            if (nums[i] < 0) {
                int temp = lmax;
                lmax = lmin;
                lmin = temp;
            }
            lmax = Math.max(lmax * nums[i], nums[i]);
            lmin = Math.min(lmin * nums[i], nums[i]);
            System.out.println(lmin + "  " +lmax);
            global = Math.max(lmax, global);

        }
        return global;
    }
}
