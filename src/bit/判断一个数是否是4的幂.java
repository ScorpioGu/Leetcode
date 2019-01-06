package bit;

/**
 * @Desc https://leetcode.com/problems/power-of-four/
 * @Author gcc
 * @Date 19-1-6 下午1:39
 **/
public class 判断一个数是否是4的幂 {
    public boolean isPowerOfFour(int num) {
        //(num & num - 1) == 0 保证二进制num中1只出现一次
        //(num & 0x55555555) != 0保证了这个1出现在奇数位置上
        return num > 0 && ((num & num - 1) == 0) && ((num & 0x55555555) != 0);
    }
}
