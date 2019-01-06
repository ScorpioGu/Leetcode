package math;

/**
 * @Desc https://leetcode.com/problems/factorial-trailing-zeroes/description/
 * @Author gcc
 * @Date 18-11-20 下午7:27
 **/
public class 求一个数的阶乘尾部有多少0 {
    /**
     * 因为所有尾部的0都来自与5 * 2,那一个数的阶乘可以写成
     * (其它数相乘) * 2 * 2...* 2 * 5 * 5 * 5....* 5
     * 注意这里是把４拆成了2 * 2, 25 拆成了5 * 5，其他数也是类似，全拆开
     * 那么就看ｎ拆了之后，有多少对５ * 2，而２的数量远远大于５的数量
     * 所以就是看有多少５
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int r = 0;
        while (n > 0) {
            n /= 5;
            r += n;
        }
        return r;
    }
}
