package math;

/**
 * @Desc TODO
 * @Author gcc
 * @Date 19-1-8 下午3:52
 **/
public class 判断一个数是否是完全平方数 {
    /**
     * 完全平方数是1 + 3 + 5 ...
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    /**
     * 通过二分法找到num的平方根
     * @param num
     * @return
     */
    public boolean isPerfectSquare2(int num) {
        int left = 0, right = num;
        while (left <= num) {
            int mid = left + (right - left)/2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    /**
     * 牛顿法
     * @param num
     * @return
     */
    public boolean isPerfectSquare3(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }


}
