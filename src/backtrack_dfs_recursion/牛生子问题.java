package backtrack_dfs_recursion;

/**
 * @Desc 一只刚出生的奶牛，3年生第一只1只奶牛，以后每一年生1只，经过n年有多少只
 *          初始给一个成熟的奶牛
 * @Author gcc
 * @Date 19-5-23 下午3:33
 **/
public class 牛生子问题 {
    public static int cowNumber1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        // n-3年的奶牛们都是成熟的奶牛，它们都可以在今年生一个
        // 这两部分，第一部分是去年原有的，第二部分就是新生的
        return cowNumber1(n - 1) + cowNumber1(n - 3);
    }

    public static int cowNumber2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        int res = 3;
        int pre = 2;
        int prepre = 1;
        int tmp1 = 0;
        int tmp2 = 0;
        for (int i = 4; i <= n; i++) {
            tmp1 = res;
            tmp2 = pre;
            res = res + prepre;
            pre = tmp1;
            prepre = tmp2;
        }
        return res;
    }
}
