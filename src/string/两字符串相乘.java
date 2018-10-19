package string;

/**
 * @Desc https://leetcode.com/problems/multiply-strings/description/
 * Example 1:
 * <p>
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 * <p>
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 * <p>
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * @Author gcc
 * @Date 18-10-17 下午7:44
 **/
public class 两字符串相乘 {
    /**
     * 说明：https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
     * 解释很清晰
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return null;
        }
        int m = num1.length();
        int n = num2.length();
        //相乘之后的长度不大于m+n
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                //千万不要犯下面这种错误,因为res[i+j+1]还是可能大于10，要先把本次结果与res[i + j + 1]相加，再对10取余、
                //res[i + j] += temp/10;
                //res[i + j + 1] += temp%10;
                int sum = temp + res[i + j + 1];
                res[i + j] += sum / 10;
                //注意是=而不是+=，前面sum中已经加了res[i + j + 1]
                res[i + j + 1] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i:res) {
            //当sb长度为0并且现在要append的数字是0是就跳过
            if (!(sb.length() == 0 && i == 0)) {
                //可以直接append int类型的
                sb.append(i);
            }
        }
        //避免0×一个数的情况返回“”，应该返回“0”的
        return sb.length() == 0?"0":sb.toString();
    }
}
