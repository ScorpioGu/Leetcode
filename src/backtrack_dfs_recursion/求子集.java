package backtrack_dfs_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc https://leetcode.com/problems/subsets/description/
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 * @Author gcc
 * @Date 18-10-30 上午10:43
 **/
public class 求子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null) {
            return lists;
        }
        Arrays.sort(nums);
        backTrack2(lists, new ArrayList<Integer>(), nums, 0);
        return lists;
    }

    /**
     * 带回溯的递归
     * @param lists
     * @param cur
     * @param nums
     * @param begin
     */
    private void backTrack(List<List<Integer>> lists, List<Integer> cur, int[] nums, int begin) {
        lists.add(new ArrayList<>(cur));
        for (int i = begin; i < nums.length; i++) {
            cur.add(nums[i]);
            backTrack(lists, cur, nums, i+1);
            cur.remove(cur.size() - 1);
        }
    }

    /**
     * 不带回溯的递归
     * 当前状态要复制
     * @param lists
     * @param cur
     * @param nums
     * @param begin
     */
    private void backTrack2(List<List<Integer>> lists, List<Integer> cur, int[] nums, int begin) {
        if (begin == nums.length) {
            lists.add(new ArrayList<>(cur));
            return;
        }
        // 不带当前数
        backTrack2(lists, new ArrayList<>(cur), nums, begin + 1);
        cur.add(nums[begin]);
        // 带当前数
        backTrack2(lists, new ArrayList<>(cur), nums, begin + 1);
    }

    public static void main(String[] args) {
        System.out.println(new 求子集().subsets(new int[]{1,2,3}));
    }
}
