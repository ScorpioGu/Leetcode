package Math;

/**
 * @Desc https://leetcode.com/problems/count-primes/description/
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * @Author gcc
 * @Date 18-11-22 下午3:42
 **/
public class 求小于n的数里面有多少个素数 {
    /**
     * 求多少个素数,转化成求多少个非素数,然后用n-1-非素数个数 = 素数个数
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        //刚开始全部默认为质数,注意规定1不是质数
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                //填充非质数
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }
}
