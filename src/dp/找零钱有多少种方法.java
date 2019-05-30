package dp;

/**
 * @Desc 比如给面值为[200,100,50,20,10,5,2,1]这些钞票，无限张，问凑出1000，共有多少种方式
 * @Author gcc
 * @Date 19-5-29 上午9:59
 **/
public class 找零钱有多少种方法 {
    public static int coins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    /**
     * 返回用arr[index]到arr[len-1]这么多货币，凑成aim的个数
     * 对上面那个例子，一张200配合process(1,800)，2*200配合process(1,600)....5*200 配合process(1,0)
     * 那么process(0,1000) = process(1,800) + ... + process(1,0)，而每一个子项又依赖它的子过程
     * base情况是index跑到了arr.length，恰好aim为0，返回1，否则返回0
     * @param arr
     * @param index
     * @param aim
     * @return
     */
    public static int process1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    public static int coinsOther(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return processOther(arr, arr.length - 1, aim);
    }

    /**
     * 和process1相反，返回用arr[0]...arr[index]可以凑成aim的个数，初始index=len-1
     * 这样做方便改dp
     * process(len-1,1000) = 1个1元配合process(len-2,999)+...+n个1元配合process(len-2,1000-n)
     * @param arr
     * @param index
     * @param aim
     * @return
     */
    public static int processOther(int[] arr, int index, int aim) {
        int res = 0;
        if (index == -1) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += processOther(arr, index - 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    /**
     * 上述的processOther，参数arr不变，当index和aim固定了，返回值也就固定了，所以可以用二维数组去存储之前计算的结果
     * @param arr
     * @param aim
     * @return
     */
    public static int coins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] map = new int[arr.length + 1][aim + 1];
        return process2(arr, 0, aim, map);
    }

    public static int process2(int[] arr, int index, int aim, int[][] map) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            int mapValue = 0;
            for (int i = 0; arr[index] * i <= aim; i++) {
                mapValue = map[index + 1][aim - arr[index] * i];
                if (mapValue != 0) {
                    res += mapValue == -1 ? 0 : mapValue;
                } else {
                    res += process2(arr, index + 1, aim - arr[index] * i, map);
                }
            }
        }
        map[index][aim] = res == 0 ? -1 : res;
        return res;
    }

    /**
     * 将记忆化递归使用dp优化
     * base情况是index=-1,aim=0为1，index=-1,aim！=0为0，数组长度不能为负，那么把index这一维的长度+1
     * @param arr
     * @param aim
     * @return
     */
    public static int coins3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        // 无论钞票面值，凑成0的方式就1种，就是什么都不选，这是初始化第一列
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        // 初始化第一列，aim为arr[0]整数倍的地方都为1
        for (int j = 1; arr[0] * j <= aim; j++) {
            dp[0][arr[0] * j] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                int num = 0;
                for (int k = 0; j - arr[i] * k >= 0; k++) {
                    num += dp[i - 1][j - arr[i] * k];
                }
                dp[i][j] = num;
            }
        }
        return dp[arr.length - 1][aim];
    }

    public static int coins4(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; arr[0] * j <= aim; j++) {
            dp[0][arr[0] * j] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
            }
        }
        return dp[arr.length - 1][aim];
    }

    public static int coins5(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[] dp = new int[aim + 1];
        for (int j = 0; arr[0] * j <= aim; j++) {
            dp[arr[0] * j] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[j] += j - arr[i] >= 0 ? dp[j - arr[i]] : 0;
            }
        }
        return dp[aim];
    }
}
