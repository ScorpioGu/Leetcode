package bit;

/**
 * @Desc https://leetcode.com/problems/maximum-product-of-word-lengths/
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 *
 * Example 1:
 *
 * Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 * Example 2:
 *
 * Input: ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4
 * Explanation: The two words can be "ab", "cd".
 * Example 3:
 *
 * Input: ["a","aa","aaa","aaaa"]
 * Output: 0
 * Explanation: No such pair of words.
 * @Author gcc
 * @Date 18-12-25 下午3:39
 **/
public class 求字符数组中两字符串长度乘积的最大值 {
    /**
     * 这道题要解决的是如何判断两个字符串是否有相同的字符,题目中只包含
     * 26个小写字母给了我们提示,可以用位运算,每个字符可以转成一个二进制数
     * 两个字符串对应的二进制按位或,如果为0,说明没有相同的字符
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        int maxProduct = 0;
        //存储字符串对应的二进制数
        int[] bits = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String temp = words[i];
            bits[i] = 0;
            for (char c : temp.toCharArray()) {
                bits[i] |= 1 << (c - 'a');
            }
        }

        for (int i = 0; i < bits.length; i++) {
            for (int j = i+1; j < bits.length; j++) {
                if ((bits[i] & bits[j]) == 0  && (words[i].length() * words[j].length() > maxProduct)) {
                    System.out.println(bits[i] + ":" + bits[j]);
                    maxProduct = words[i].length() * words[j].length();
                }
            }
        }

        return maxProduct;
    }

}
