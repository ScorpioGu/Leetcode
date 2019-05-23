package backtrack_dfs_recursion;

import java.util.LinkedList;
import java.util.List;

/**
 * @Desc https://leetcode.com/problems/combination-sum-iii/description/
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 * @Author gcc
 * @Date 18-11-26 下午12:48
 **/
public class 和为目标数的序列组合III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        backTrack(res, new LinkedList<>(), 1, k, n);
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> cur, int begin, int remainCount, int remainSum) {
        if (remainSum < 0 || remainCount < 0) {
            return;
        }
        if (remainCount == 0 && remainSum == 0) {
            res.add(new LinkedList<>(cur));
            return;
        }
        for (int i = begin; i <= Math.min(9, remainSum); i++) {
            cur.add(i);
            backTrack(res, cur, i + 1, remainCount - 1, remainSum - i);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new 和为目标数的序列组合III().combinationSum3(2, 18));
    }
}
