package string;

/**
 * @Desc https://leetcode.com/problems/add-binary/description/
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * @Author gcc
 * @Date 18-10-24 下午7:59
 **/
public class 两个二进制字符串相加 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        //两两个指针分别指向两个字符串，两指针同时移动。
        //用||的关系，当其中一个指针到头之后，另一指针仍然在移动
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        //StringBuilder的reverse方法，逆转字符串
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new 两个二进制字符串相加().addBinary("011", "111"));
    }
}
