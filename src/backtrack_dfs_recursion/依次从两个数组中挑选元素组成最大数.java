package backtrack_dfs_recursion;

import java.util.Stack;

/**
 * @Desc https://leetcode.com/problems/create-maximum-number/
 * @Author gcc
 * @Date 19-1-2 上午10:09
 **/
public class 依次从两个数组中挑选元素组成最大数 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        //TODO 准备一下这个题目 面试题:刷题中遇到的最难的题目
        // 从第一个数组中选出长度为i最大的，那么就要从第二个里选出长度为k-i最大的,组成两个的数组，注意这两个数组不一定有序，比如3,4,6,2，k=2,返回6,2而不是4,6
        // 第一个数组长度为n，第二个为m
        // 0<=i<=n,0<=k-i<=m
        // 那么max(0，k-m）<=i<=min(n,k)
        // 遍历i，对每一个i，merge两个数组，组成一个新数组。同时维护一个最大的数组。
        int n = nums1.length, m = nums2.length;
        int[] opt = new int[k];
        for (int i = Math.max(0, k - m); i <= Math.min(n, k); i++) {
            int[] candidate = merge(getMaxK(nums1, i), getMaxK(nums2, k - i));
            opt = greater(candidate, 0, opt, 0) ? candidate : opt;
        }
        return opt;
    }


    private int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // m + n 一定是k
        int[] res = new int[m + n];
        for (int i = 0, j = 0, r = 0; r < m + n; ++r) {
            res[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return res;
    }

    /**
     * nums1从i开始，nums2从j，开始哪一个代表的数值大
     * @param nums1
     * @param i
     * @param nums2
     * @param j
     * @return
     */
    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }

        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    private int[] getMaxK(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (stack.size() + nums.length - i > k && !stack.isEmpty() && stack.peek() < nums[i]) {
                stack.pop();
            }

            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            if (!stack.isEmpty()) {
                res[k-1-i] = stack.pop();
            }
        }
        return res;
    }
}
