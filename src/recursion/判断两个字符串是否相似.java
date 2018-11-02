package recursion;

/**
 * @Desc https://leetcode.com/problems/scramble-string/description/
 * Example 1:
 *
 * Input: s1 = "great", s2 = "rgeat"
 * Output: true
 * @Author gcc
 * @Date 18-11-2 上午9:23
 **/
public class 判断两个字符串是否相似 {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        //判断两个串包含的字符是否相同,如果不相同必然是不相似的
        int[] chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i) - 'a']++;
            chars[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) {
                return false;
            }
        }
        //必须要分成两个非空的串,substring是左闭右开的,所以遍历从1到s1.length-1
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(s2.length()-i)) && isScramble(s1.substring(i), s2.substring(0,s2.length()-i))) {
                return true;
            }
        }
        return false;
    }
}
