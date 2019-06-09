package string;

/**
 * @Desc https://leetcode.com/problems/valid-anagram/
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * @Author gcc
 * @Date 18-12-3 下午5:07
 **/
public class 判断两字符串是否为anagrams {
    /**
     * 因为只有小写字母,所以可以用一个长度为26的数组保存字符出现的次数
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] mem = new int[26];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        if (sc.length != tc.length) {
            return false;
        }

        for (int i = 0; i < sc.length; i++) {
            mem[sc[i] - 'a']++;
            mem[tc[i] - 'a']--;
        }
        for (int i : mem) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
