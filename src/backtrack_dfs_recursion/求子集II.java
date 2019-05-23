package backtrack_dfs_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc https://leetcode.com/problems/subsets-ii/description/
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * @Author gcc
 * @Date 18-11-2 上午10:49
 **/
public class 求子集II {
    /**
     * 与求子集那题的不同之处在于nums中可存在重复元素
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        boolean[] isUsed = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(res, new ArrayList<>(), nums, isUsed, 0);
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> cur, int[] nums, boolean[] isUsed, int begin) {
        res.add(new ArrayList<>(cur));
        for (int i = begin; i < nums.length; i++) {
            if (isUsed[i]) {
                continue;
            }
            if (i>0 && nums[i-1] == nums[i] && !isUsed[i-1]) {
                continue;
            }
            isUsed[i] = true;
            cur.add(nums[i]);
            backTrack(res, cur, nums, isUsed, i + 1);
            isUsed[i] = false;
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new 求子集II().subsetsWithDup(new int[]{1, 2, 2});
        for (int i = 0; i < res.size(); i++) {
            System.out.println(".........");
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.println(res.get(i).get(j));
            }
        }
    }
}
