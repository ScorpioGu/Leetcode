package binarySearch;

import java.util.Arrays;

/**
 * @Desc https://leetcode.com/problems/longest-increasing-subsequence/
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 * 最长递增子序列,只需要递增,而不需要连续.
 * 一篇比较好的博客:https://segmentfault.com/a/1190000003819886
 * @Author gcc
 * @Date 18-12-16 上午11:20
 **/
public class 最长递增子序列 {
    /**
     * 动态规划的做法,时间复杂度o(n^2)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        //dp[i]记录了nums[0]...nums[i]这一段的最长递增子序列的长度
        //dp[j]可能来自于dp[0]...dp[j-1],如果nums[j] > nums[i](i<j),那么dp[j] = Math.max(dp[j], dp[i] + 1);
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else {
                    dp[i] = Math.max(dp[i], 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    /**
     * 二分法,这个思路直接看博客吧,写的很好的
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //当前最长lis的长度,为了方便先将其减1
        int len = 0;
        //tails[i]表示长度为i的升序序列其末尾的数字,这个升序序列保证同长度的升序序列中,其末尾数字最小
        //因为末尾数字越小,越容易使得后面新元素加入时升序序列更长.
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < tails[0]) {
                tails[0] = nums[i];
            } else if (nums[i] > tails[len]) {
                tails[++len] = nums[i];
            } else {
                //二分查找,如果能找到,返回其索引,相当于没变
                //如果没找到,返回新元素应该插入的位置,然后去修改它
                tails[Arrays.binarySearch(tails, 0, len, nums[i])] = nums[i];
            }
        }
        return len+1;
    }

    /**
     * 二分查找,如果能找到返回下标,如果找不到,返回该插入的位置
     * JDK提供的Arrays.binarySearch,如果找不到的话返回的是一个负值,所以不要用
     * @param tails
     * @param min
     * @param max
     * @param target
     * @return
     */
    private int binarySearch(int[] tails, int min, int max, int target){
        while(min <= max){
            int mid = min + (max - min) / 2;
            if(tails[mid] == target){
                return mid;
            }
            if(tails[mid] < target){
                min = mid + 1;
            }
            if(tails[mid] > target){
                max = mid - 1;
            }
        }
        return min;
    }

}
