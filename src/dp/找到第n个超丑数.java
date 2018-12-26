package dp;

/**
 * @Desc https://leetcode.com/problems/super-ugly-number/
 * @Author gcc
 * @Date 18-12-20 下午9:13
 **/
public class 找到第n个超丑数 {
    /**
     * 和前一题做法相同
     * @param n
     * @param primes
     * @return
     */
    public int nthSuperUglyNumberI(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];

        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            //find next
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);
            }
            //slip duplicate
            for (int j = 0; j < primes.length; j++) {
                while (primes[j] * ugly[idx[j]] <= ugly[i]) idx[j]++;
            }
        }

        return ugly[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new 找到第n个超丑数().nthSuperUglyNumberI(10, new int[]{2,3,5}));
    }
}
