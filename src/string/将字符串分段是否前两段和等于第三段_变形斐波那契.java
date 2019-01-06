package string;

/**
 * @Desc https://leetcode.com/problems/additive-number/
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 *
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 *
 * Example 1:
 *
 * Input: "112358"
 * Output: true
 * Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 *              1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * Example 2:
 *
 * Input: "199100199"
 * Output: true
 * Explanation: The additive sequence is: 1, 99, 100, 199.
 *              1 + 99 = 100, 99 + 100 = 199
 * @Author gcc
 * @Date 18-12-19 下午5:21
 **/
public class 将字符串分段是否前两段和等于第三段_变形斐波那契 {
    /**
     * i,j表示第一个数和第二个数的长度,则第三个数的长度为len-i-j必然是>=math.max(i,j),且i必然是不能过半
     * @param num
     * @return
     */
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        for (int i = 1; i <= len/2; i++) {
            for (int j = 1; Math.max(i, j) <= len - i - j; j++) {
                if (isValid(i, j, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int i, int j, String num) {
        //若数的长度>1,那么起始位置不可以为0
        if (num.charAt(0) == '0' && i > 1) {
            return false;
        }
        if (num.charAt(i) == '0' && j > 1) {
            return false;
        }
        Long x1 = Long.parseLong(num.substring(0, i));
        Long x2 = Long.parseLong(num.substring(i, i + j));
        String sum;
        for (int start = i + j; start != num.length(); start+=sum.length()) {
            //迭代,将原先两数的和作为下次迭代的第二个数
            //原先的第二段作为下次迭代的第一段
            x2 = x2 + x1;
            x1 = x2 - x1;
            sum = x2.toString();
            if (!num.startsWith(sum, start)) {
                return false;
            }
        }
        return true;
    }
}
