package array;

/**
 * @Desc https://leetcode.com/problems/burst-balloons/
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 *
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * Note:
 *
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * Example:
 *
 * Input: [3,1,5,8]
 * Output: 167
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *              coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * @Author gcc
 * @Date 18-12-20 上午11:07
 **/
public class 炸气球问题 {
    public int maxCoins(int[] nums) {
        //一个新的便于计算的数组,首尾添1,将原数组中的0删去
        int[] newNums = new int[nums.length + 2];
        int n = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                newNums[n++] = nums[i];
            }
        }
        newNums[0] = newNums[n++] = 1;

        //避免重复计算,mem[left][right]记录burst[left][right]的返回值
        int[][] mem = new int[n][n];
        return burst(mem, newNums, 0, n-1);
    }

    /**
     * burst(left, right)表示将[left+1,right-1]范围内的气球炸光所得的最大coins
     * 显然炸光了之后,剩下了两就是left和right
     * @param mem
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int burst(int[][] mem, int[] nums, int left, int right) {
        //如果left+1=right,说明没有气球可以炸了,返回0
        if (left + 1 == right) {
            return 0;
        }
        if (mem[left][right] > 0) {
            return mem[left][right];
        }
        int max = 0;
        //现在从[left+1, right-1]中挑出一个k,让k的两边炸光,让这个k最后炸,使得结果最大
        //因为两边都炸光了,最后k的两个邻居一定是left和right

        //注意挑出的k一定不能是第一个炸,因为第一个炸了,左右两边会相邻,没有办法分治
        for (int k = left + 1; k < right ; k++) {
            max = Math.max(max, burst(mem, nums, left, k) + nums[left] * nums[k] * nums[right] + burst(mem, nums, k, right));
        }
        mem[left][right] = max;
        return max;
    }

}
