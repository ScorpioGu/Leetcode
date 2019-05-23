package backtrack_dfs_recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc https://leetcode.com/problems/lexicographical-numbers/
 * Given an integer n, return 1 - n in lexicographical order.
 *
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 *
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 *
 * 1,2,3,...,9按照次序dfs,与n比较
 * @Author gcc
 * @Date 19-1-13 下午8:06
 **/
public class 小于等于k的所有数按字典序排序 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }

        for (int i = 1; i <=9 ; i++) {
            dfs(res, i, n);
        }
        return res;
    }

    private void dfs(List<Integer> list, int cur, int n) {
        if (list.size() == n) {
            return;
        }
        list.add(cur);
        for (int i = 0; i <=9 ; i++) {
            int next = 10 * cur + i;
            if (next > n) {
                return;
            } else {
                dfs(list, next, n);
            }
        }
        return;
    }

}
