package backtrack_dfs_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc https://leetcode.com/problems/combination-sum/description/
 * 从不重复的数组中寻找和为target的数字组合,要求组合不重复
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * @Author gcc
 * @Date 18-10-10 下午2:42
 **/
public class 和为目标数的序列组合 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        //先排个序，为避免重复，后面加入的元素必须比之前的大
        Arrays.sort(candidates);
        backTrack(res, cur, target, candidates, 0);
        return res;
    }

    /**
     *
     * @param list 结果
     * @param cur  当前遍历的路径
     * @param remain
     * @param candidates
     * @param start 从candadates寻找的位置，保证不重复
     */
    private void backTrack(List<List<Integer>> list, List<Integer> cur, int remain, int[] candidates, int start) {
        if (remain < 0) {
            //这里做的是剪枝
            return;
        } else if (remain == 0) {
            list.add(new ArrayList<>(cur));
            //注意不能写成下面这种，必须复制一份存储。因为cur后续的搜寻中还会变
            //list.add(cur);
        } else {
            for (int i = start; i < candidates.length; i++) {
                //depth+1
                cur.add(candidates[i]);
                //判断当前状态
                backTrack(list, cur, remain - candidates[i], candidates, i);
                //depth-1 状态还原，remain,cur都未改变
                cur.remove(cur.size() - 1);
            }
        }
    }
}
