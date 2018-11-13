package backtrack_dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc https://leetcode.com/problems/combinations/description/
 * @Author gcc
 * @Date 18-10-30 上午10:21
 **/
public class 排列组合中CxY {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(res, new ArrayList<>(), n, 1, k);
        return res;
    }

    private void recursion(List<List<Integer>> lists, List<Integer> cur, int end, int begin, int k) {
        if (cur.size() == k) {
            lists.add(new ArrayList<>(cur));
            return;
        }
        for (int i = begin; i <= end; i++) {
            cur.add(i);
            recursion(lists, cur, end, i+1, k);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new 排列组合中CxY().combine(4,2));
    }
}
