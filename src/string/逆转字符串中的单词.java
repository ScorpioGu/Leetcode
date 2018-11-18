package string;

/**
 * @Desc https://leetcode.com/problems/reverse-words-in-a-string/description/
 * Given an input string, reverse the string word by word.
 *
 * Example:
 *
 * Input: "the sky is blue",
 * Output: "blue is sky the".
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 * @Author gcc
 * @Date 18-11-18 上午11:53
 **/
public class 逆转字符串中的单词 {
    /**
     * 注意要去掉首尾的空格,单词间的多个空格也要变成单个空格
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        //String.split()是可以传入正则表达式的,所以对多个空格的处理只需要使用" +"正则即可
        String[] ss = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length-1; i >= 0 ; i--) {
            if (i == 0) {
                sb.append(ss[i]);
            } else {
                sb.append(ss[i] + " ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new 逆转字符串中的单词().reverseWords("the sky is blue"));
    }
}
