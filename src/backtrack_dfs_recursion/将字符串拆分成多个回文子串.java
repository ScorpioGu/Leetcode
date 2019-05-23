package backtrack_dfs_recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc https://leetcode.com/problems/palindrome-partitioning/description/
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 * @Author gcc
 * @Date 18-11-15 下午3:54
 **/
public class 将字符串拆分成多个回文子串 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        //isPal[i][j]代表s.subString(i, j + 1)是回文串
        boolean[][] isPal = new boolean[s.length()][s.length()];
        //注意下面这种写法是错误的
/*        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length() ; j++) {
                //j - i == 0 对应于单个字符, ==1 对应于'aa'的形式, ==2对应于'aba'的形式
                //注意此时可能isPal[i+1][j-1]还没有被初始赋值,所以是错误的,程序的赋值顺序是[0, 0], [0, 1], [0, 2], [0, 3]....[1, 1], [1, 2]
                //而执行到[0,3]时,其值依赖于[1,2],而此时[1,2]还未被赋值,所以可能导致错误的结果
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                }
            }
        }*/
        //必须把end指针放在外层循环
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j ; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                }
            }
        }
        backTrack(res, new ArrayList<>(), s, 0, isPal);
        return res;
    }

    /**
     * 回溯,如果不适用isPal矩阵的话,是会带来很多冗余计算的
     * @param res
     * @param cur
     * @param s
     * @param begin
     * @param isPal
     */
    private void backTrack(List<List<String>> res, List<String> cur, String s, int begin, boolean[][] isPal) {
        if (begin == s.length()) {
            res.add(new ArrayList<>(cur));
        } else {
            for (int i = begin; i < s.length(); i++) {
                if (isPal[begin][i]) {
                    cur.add(s.substring(begin, i + 1));
                    backTrack(res, cur, s, i + 1, isPal);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        new 将字符串拆分成多个回文子串().partition("abbab");
    }
}
