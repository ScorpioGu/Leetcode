package math;

/**
 * @Desc https://leetcode.com/problems/ugly-number/
 * 丑数的定义是一个数的因数只包括2,3,5
 * @Author gcc
 * @Date 18-12-20 下午8:24
 **/
public class 判断是否为丑数 {
    public boolean isUgly(int num) {
        if (num == 1) {
            return true;
        }
        if (num == 0) {
            return false;
        }
        while (num % 2 == 0) {
            num = num >> 1;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }

        while (num % 5 == 0) {
            num = num / 5;
        }

        return num==1;
    }
}
