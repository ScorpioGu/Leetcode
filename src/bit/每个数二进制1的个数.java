package bit;

/**
 * @Desc https://leetcode.com/problems/counting-bits/
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: [0,1,1]
 * Example 2:
 * <p>
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * @Author gcc
 * @Date 19-1-6 上午11:28
 **/
public class 每个数二进制1的个数 {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            //一个数n, 与n/2,1的个数一定相差0或者1个.如果n是奇数相差1,如果n是偶数相差0
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}
