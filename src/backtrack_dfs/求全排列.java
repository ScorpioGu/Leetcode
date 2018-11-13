package backtrack_dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc https://leetcode.com/problems/permutations/description/
 * @Author gcc
 * @Date 18-10-19 下午10:01
 **/
public class 求全排列 {
    /**
     * 回溯法做即可
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        backTrack(lists, new ArrayList<Integer>(), nums);
        return lists;
    }

    private void backTrack(List<List<Integer>> lists, List<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            lists.add(new ArrayList<>(cur));
            return;
        } else {
            for (int i=0; i<nums.length; i++) {
                if (cur.contains(nums[i])) {
                    continue;
                }
                cur.add(nums[i]);
                backTrack(lists, cur, nums);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
