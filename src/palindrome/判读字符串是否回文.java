package palindrome;

/**
 * @Desc https://leetcode.com/problems/valid-palindrome/
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 * @Author gcc
 * @Date 19-6-10 下午10:37
 **/
public class 判读字符串是否回文 {

    // 这道题只考虑字母和数字，忽略大小写，忽略其他字符空格
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        // 忽略大小写
        s = s.toLowerCase();
        int l = 0, r = s.length()-1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
