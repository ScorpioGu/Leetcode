package dp;

/**
 * @Desc https://leetcode.com/problems/Increasing Triplet Subsequence/
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 *
 * Formally the function should:
 *
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5]
 * Output: true
 * Example 2:
 *
 * Input: [5,4,3,2,1]
 * Output: false
 * @Author gcc
 * @Date 19-1-4 上午11:18
 **/
public class 判断序列中是否有长度为3的递增子序列 {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int len = nums.length;
        // min代表了当前的最小值,max代表当前的次小值,若存在一个数比两者都大,则返回true
        // 一旦max被更新了，说明一定会有一个数小于max，那么我们就成功的组成了一个长度为2的递增子序列，
        // 所以我们一旦遍历到比m2还大的数，我们直接返回ture。如果我们遇到比m1小的数，还是要更新m1，
        // 有可能的话也要更新m2为更小的值，毕竟m2的值越小，能组成长度为3的递增序列的可能性越大
        int min = Integer.MAX_VALUE, max = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num <= max) {
                max = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
