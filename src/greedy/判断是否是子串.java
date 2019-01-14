package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Desc https://leetcode.com/problems/is-subsequence/
 * Given a string s and a string t, check if s is subsequence of t.
 *
 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Example 1:
 * s = "abc", t = "ahbgdc"
 *
 * Return true.
 *
 * Example 2:
 * s = "axc", t = "ahbgdc"
 *
 * Return false.
 *
 *     // Follow-up: O(N) time for pre-processing, O(Mlog?) for each S.
 *     // Eg-1. s="abc", t="bahbgdca"
 *     // idx=[a={1,7}, b={0,3}, c={6}]
 *     //  i=0 ('a'): prev=1
 *     //  i=1 ('b'): prev=3
 *     //  i=2 ('c'): prev=6 (return true)
 *     // Eg-2. s="abc", t="bahgdcb"
 *     // idx=[a={1}, b={0,6}, c={5}]
 *     //  i=0 ('a'): prev=1
 *     //  i=1 ('b'): prev=6
 *     //  i=2 ('c'): prev=? (return false)
 * @Author gcc
 * @Date 19-1-14 上午11:01
 **/
public class 判断是否是子串 {
    public boolean isSubsequence(String s, String t) {
        // index[i]存放字符'a' + i在t中出现的位置(下标)
        // 花了o(n)的时间做了预处理,当需要判断多个s的情况下,这个预处理只需要执行一次
        List<Integer>[] index = new List[26];
        for (int i = 0; i < t.length(); i++) {
            if (index[t.charAt(i) - 'a'] == null) {
                index[t.charAt(i) - 'a'] = new ArrayList<>();
            }
            index[t.charAt(i) - 'a'].add(i);
        }

        int pre = Integer.MIN_VALUE;
        // 为每一个字符找到它最先出现的位置idx,那么后面一个字符以一次出现的位置必须要大于等于idx+1
        // 如果后一个字符没有出现过,或者出现的位置小于等于idx,那么是无法构成子串的
        for (int i = 0; i < s.length(); i++) {
            List<Integer> cur = index[s.charAt(i) - 'a'];
            if (cur == null) {
                return false;
            }

            // 寻找pre在cur中应该插入的位置,其实是寻找cur这个list中是否有元素比pre大
            // 如果没有元素比pre大,那么插入的位置是cur.size,返回false.
            int idx = Collections.binarySearch(cur, pre);
            if (idx < 0) {
                idx = -(idx + 1);
            }
            if (idx == cur.size()) {
                return false;
            }
            pre = cur.get(idx) + 1;
        }
        return true;
    }
}
