package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc https://leetcode.com/problems/combination-sum-ii/description/
 * 变化在于，组合中不可以出现重复数字
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * @Author gcc
 * @Date 18-10-10 下午3:41
 **/
public class 和为目标数的序列组合II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        backTrack(res, new ArrayList<>(), target, candidates, 0);
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> cur, int remain, int[] candidates, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            res.add(new ArrayList<>(cur));
        } else {
            for (int i = start; i < candidates.length; i++) {
                //排除重复元素
                if (i > start && candidates[i] == candidates[i-1]) {
                    continue;
                }
                cur.add(candidates[i]);
                //start+1，排除重复元素，深度遍历不能再选自己了
                backTrack(res, cur, remain - candidates[i], candidates,  + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new 和为目标数的序列组合II().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));

    }
}
