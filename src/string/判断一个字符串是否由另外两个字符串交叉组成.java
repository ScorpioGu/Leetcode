package string;

/**
 * @Desc https://leetcode.com/problems/interleaving-string/description/
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * Example 1:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Example 2:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * @Author gcc
 * @Date 18-11-2 下午8:30
 **/
public class 判断一个字符串是否由另外两个字符串交叉组成 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        //TODO
    }

    public static void main(String[] args) {
        System.out.println(new 判断一个字符串是否由另外两个字符串交叉组成().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
