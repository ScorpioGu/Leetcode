package huiwen;

/**
 * @Desc https://leetcode.com/problems/shortest-palindrome/description/
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 *
 * Example 1:
 *
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 * Example 2:
 *
 * Input: "abcd"
 * Output: "dcbabcd"
 * @Author gcc
 * @Date 18-11-25 下午7:18
 **/
public class 在字符串前添加字符使其成为最短的回文串 {
    /**
     * 问题转化为求包含第一个字符的最长回文串，那么在这个字符串前要加上的就是原串中去掉包含回文串的剩余部分的逆转
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        // 这样构成的串一定是回文的
        // 串可以分为两部分，左边部分的一段与右边部分的相应段也是回文的，或者说是字符串翻转的
        // 那么已知开头段与结尾段，只要它们长度相同，肯定开头段等于结尾段的翻转，如果本身不翻转也相等（求next数组），必然开头段本身是回文的
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        //求next数组
        int[] table = getNextArray(temp);
        int beginIndex = table[table.length - 1];
        if (beginIndex == -1) {
            return new StringBuilder(s).reverse() + s;
        }
        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }


    public static int[] getNextArray(String s) {
        char[] ms = s.toCharArray();
        if (ms.length == 1) {
            return new int[] { -1};
        }
        int[] next = new int[ms.length + 1];
        // 这两个固定
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(new 在字符串前添加字符使其成为最短的回文串().shortestPalindrome("catacb"));
    }
}
