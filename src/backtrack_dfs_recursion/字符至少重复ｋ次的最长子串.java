package backtrack_dfs_recursion;

/**
 * @Desc https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
 * Example 1:
 * Input:
 * s = "aaabb", k = 3
 * Output:
 * 3
 *
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 * Input:
 * s = "ababbc", k = 2
 * Output:
 * 5
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 *
 * @Author gcc
 * @Date 19-1-14 下午4:31
 **/
public class 字符至少重复ｋ次的最长子串 {
    public int longestSubstring(String s, int k) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        // 统计字符串s中各个字符出现的次数,那些出现次数>0小于k的将作为分隔符
        // 只有分隔符之内的子串才有可能是符合条件的子串,对其再进行判断
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        boolean flag = true;
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0 && counts[i] < k) {
                flag = false;
            }
        }
        if (flag == true) {
            return s.length();
        }

        int res = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (counts[index] > 0 && counts[index] < k) {
                res = Math.max(res, longestSubstring(s.substring(start, i), k));
                start = i + 1;
            }
        }
        //最后一个分割点剩余的部分
        res = Math.max(res, longestSubstring(s.substring(start), k));
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 字符至少重复ｋ次的最长子串().longestSubstring("aaabb", 3));
    }
}
