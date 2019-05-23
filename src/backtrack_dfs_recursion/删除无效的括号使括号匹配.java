package backtrack_dfs_recursion;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @Desc https://leetcode.com/problems/remove-invalid-parentheses/
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Example 1:
 *
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * Example 2:
 *
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * Example 3:
 *
 * Input: ")("
 * Output: [""]
 * @Author gcc
 * @Date 18-12-19 上午10:10
 **/
public class 删除无效的括号使括号匹配 {
    public List<String> removeInvalidParentheses(String s) {
        //首先先确定,要删除的最少的左括号与右括号个数rml,rmr
        //((),这种的rml=1,rmr=0;)))((((这种的就是rml=4,rmr=3
        int rml = 0, rmr = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                rml++;
            } else if (c == ')') {
                if (rml == 0) {
                    rmr++;
                } else {
                    rml--;
                }
            }
        }
        Set<String> res = new HashSet<>();
        dfs(res, new StringBuilder(), 0, rml, rmr, 0, s);
        return new LinkedList<>(res);

    }

    /**
     *
     * @param res
     * @param sb
     * @param index
     * @param rml 还需要删除的左括号的个数
     * @param rmr 还需要删除的右括号的个数
     * @param open 目前还未匹配的左括号
     */
    private void dfs(Set<String> res, StringBuilder sb, int index, int rml, int rmr, int open, String s) {
        if (rml < 0 || rmr < 0 || open < 0) {
            return;
        }
        //rml,rmr=0保证了删除的括号个数达到最小,open=0保证了括号左右匹配
        if (index == s.length()) {
            if (rml == 0 && rmr == 0 && open == 0) {
                res.add(sb.toString());
            }
            return;
        }
        char c = s.charAt(index);
        int len = sb.length();
        //遇到情况下是加上这个括号,另一种情况是不加这个括号
        //加上括号可能会带来括号不匹配的问题,导致open<0
        //删除括号可能会带来rml或者rmr<0,即删多了,这两种情况都能做了处理
        if (c == '(') {
            //必须要是删去当前字符的情况 写在 不删除当前字符的前面.下面两行不能颠倒
            dfs(res, sb, index + 1, rml - 1, rmr, open, s);
            dfs(res, sb.append(c), index + 1, rml, rmr, open + 1, s);
        } else if (c == ')') {
            dfs(res, sb, index + 1, rml, rmr - 1, open, s);
            dfs(res, sb.append(c), index + 1, rml, rmr, open - 1, s);
        } else {
            dfs(res, sb.append(c), index + 1, rml, rmr, open, s);
        }
        //还原sb
        sb.setLength(len);
    }

    public static void main(String[] args) {
        System.out.println(new 删除无效的括号使括号匹配().removeInvalidParentheses("()())()"));
    }
}
