package string;

/**
 * @Desc https://leetcode.com/problems/isomorphic-strings/description/
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "egg", t = "add"
 * Output: true
 * @Author gcc
 * @Date 18-11-22 下午4:06
 **/
public class 判断字符串是否同构 {
    public boolean isIsomorphic(String s, String t) {
        //前128个坑放s,后128个坑放t
        int[] m = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (m[s.charAt(i)] != m[t.charAt(i) + 128]) {
                return false;
            }
            m[s.charAt(i)] = m[t.charAt(i) + 128] = i + 1;
        }
        return true;
    }
}
