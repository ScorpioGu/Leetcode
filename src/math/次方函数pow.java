package math;

/**
 * @Desc https://leetcode.com/problems/powx-n/description/
 * @Author gcc
 * @Date 18-10-22 下午8:31
 **/
public class 次方函数pow {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / x * myPow(1 / x, -(n + 1));
        }
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        }
        return myPow(x * x, n / 2) * x;
    }
}
