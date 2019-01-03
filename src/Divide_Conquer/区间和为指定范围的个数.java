package Divide_Conquer;

import java.util.Arrays;

/**
 * @Desc https://leetcode.com/problems/count-of-range-sum/
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.
 *
 * Note:
 * A naive algorithm of O(n2) is trivial. You MUST do better than that.
 *
 * Example:
 *
 * Input: nums = [-2,5,-1], lower = -2, upper = 2,
 * Output: 3
 * Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
 * @Author gcc
 * @Date 19-1-3 下午5:12
 **/
public class 区间和为指定范围的个数 {
    /**
     * 分治来作,就是找两个索引i和j,使得[i, j]元素和在某以范围内.那么我现在把这个数组一分为二[left, m], [m+1, right]
     * 那么就有三种情况,1. i,j在左半边 2. i,j在右半边. 3. i在左半边, j在右半边.
     * 第一种与第二种情况是子问题,我们主要考虑第三种情况.因为区间是连续的,那么针对这种情况,需要拿出左半边的尾巴部分和右半边的开头部分.
     * 使用一个后缀和数组suffix来存储左半边的从后往前的元素和,prefix存储右半边的从前往后的元素和.如果遍历prefix,suffix,从中各挑选处一个值相加
     * 判断是否在范围内,那么时间复杂度依然是o(n^2).注意到这是一个范围判断的题,我们可以把prefix数组排序,对任意一个suffix中的元素m,只要找到
     * prefix中下界(大于等于lower - m)的坐标,上界(小于等于 upper - m)的坐标,作差得到的就是个数.
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0 || lower > upper) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1, lower, upper);
    }

    private int helper(int[] nums, int left, int right, int lower, int upper) {
        if (left == right) {
            if (nums[left] >= lower && nums[right] <= upper) {
                return 1;
            } else {
                return 0;
            }
        }

        int mid = left + (right - left)/2;
        long[] prefix = new long[right - mid];
        long sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            prefix[i - mid - 1] = sum;
        }

        Arrays.sort(prefix);

        sum = 0;
        int count = 0;
        for (int i = mid; i >= left ; i--) {
            sum += nums[i];
            //这里为什么要+0.5, -0.5?
            //比如说prefix是[1,3,5,7], 上下界是[3,5],[2,5],[2,6]这三种情况,这三种情况返回的count应该都是2,也就是3和5
            //但是findIndex这份方法是找到target的下标,如果找不到就返回其应该插入的下标.
            //那么[3,5]的情况,下标分别是1,2 差值为1 [2,5]的情况,下标分别是1,2差值为1, [2,6]的情况下标分别为1, 3,差值为2
            //三种情况算出的结果并不一样,这种因为恰好上下界恰好存在于prefix数组中,为解决这种问题,我们把上下界适当放宽0.5,保证
            //上下界不在prefix数组中即可.
            count += findIndex(prefix, upper - sum + 0.5) - findIndex(prefix, lower - sum - 0.5);

        }
        return helper(nums, left, mid, lower, upper) + helper(nums, mid + 1, right, lower, upper) + count;
    }

    /**
     * 查找val在nums应该插入的位置
     * @param nums
     * @param target
     * @return
     */
    private int findIndex(long[] nums, double target) {
        if (nums == null) {
            return -1;
        }
        int begin = 0, end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return begin;
    }
}
