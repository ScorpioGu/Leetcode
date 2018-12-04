package bitwise;

/**
 * @Desc https://leetcode.com/problems/power-of-two/
 * @Author gcc
 * @Date 18-12-3 上午9:46
 **/
public class 判断一个树是否是2的幂 {
    /**
     * 2的幂转成2进制的特点是 只有1一个1,其他都为0
     * 比如100, 1000等等 这样的数有一个特点就是 n&n-1 = 0
     * 比如1000 & 0111 = 0
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return true;
        }
        return (n & n - 1) == 0 ? true:false;
    }
}
