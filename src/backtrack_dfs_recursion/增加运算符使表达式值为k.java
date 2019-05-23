package backtrack_dfs_recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc https://leetcode.com/problems/expression-add-operators/
 *
 * Example 1:
 *
 * Input: num = "123", target = 6
 * Output: ["1+2+3", "1*2*3"]
 * Example 2:
 *
 * Input: num = "232", target = 8
 * Output: ["2*3+2", "2+3*2"]
 *
 * @Author gcc
 * @Date 18-12-14 上午9:56
 **/
public class 增加运算符使表达式值为k {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        dfs(res, "", num, target, 0, 0, 0);
        return res;
    }

    /**
     *
     * @param res
     * @param path
     * @param num
     * @param target
     * @param pos 当前位置
     * @param eval 当前表达式的值 定义成long是防止overflow
     * @param multed 保存如果下个符号是乘号的话,上一个待乘的值
     */
    private void dfs(List<String> res, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length() && eval == target) {
            res.add(path);
            return;
        }
        for (int i = pos; i < num.length() ; i++) {
            //单独的0可以放行,但是0后面继续跟数字就不可以了
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }
            //类似012,这样的串是无法强转成long的,需要在之前对这种情况处理
            Long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                dfs(res, path + cur, num, target, i+1, cur, cur);
            } else {
                dfs(res, path + "+" + cur, num, target, i+1, eval + cur, cur);
                dfs(res, path + "-" + cur, num, target, i+1, eval - cur, -cur);
                dfs(res, path + "*" + cur, num, target, i+1, eval - multed + multed * cur, multed * cur);
            }
        }
    }
}
