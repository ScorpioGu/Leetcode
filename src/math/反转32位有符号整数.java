package math;

/**
 * https://leetcode.com/problems/reverse-integer/description/
 * 因为有数字反转，要考虑溢出的情况。
 */
public class 反转32位有符号整数 {
    public int reverse(int x) {
        int result = 0;
        //结束的标志是原来的数变为0
        while (x != 0) {
            int remain = x % 10;
            int newResult = result * 10 + remain;
            //对于不溢出的数，对一个数操作之后然后还原应该是相等的。
            //但对于溢出的数，乘10再加其他一个数溢出的话，还原之后是不想等的，根据这个判断是否溢出
            if ((newResult - remain) / 10 != result) {
                return 0;
            }
            result = newResult;
            x /= 10;
        }
        return result;
    }

    //或者是用long来存储，然后进行判断一下
    public int reverse2(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(new 反转32位有符号整数().reverse(10900)
        );
    }
}
