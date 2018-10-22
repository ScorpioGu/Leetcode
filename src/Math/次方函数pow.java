package Math;

/**
 * @Desc https://leetcode.com/problems/powx-n/description/
 * @Author gcc
 * @Date 18-10-22 下午8:31
 **/
public class 次方函数pow {
    public double myPow(double x, int n) {
        long nL = (long) n;
        return pow(x, nL);
    }

    private double pow(double x, long n) {
        if (n == 0) return 1;
        if (n < 0) return 1.0 / pow (x, -n);
        double res = 1;
        while (n != 0) {
            double curRes = x;
            long cnt = 1;
            while (n > 2 * cnt) {
                curRes *= curRes;
                cnt += cnt;
            }
            res *= curRes;
            n = n - cnt;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 次方函数pow().myPow(3, 3));
    }
}
