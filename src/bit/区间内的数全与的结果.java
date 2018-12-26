package bit;

/**
 * @Desc https://leetcode.com/problems/bit-and-of-numbers-range/description/
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bit AND of all numbers in this range, inclusive.
 *
 * Example 1:
 *
 * Input: [5,7]
 * Output: 4
 * Example 2:
 *
 * Input: [0,1]
 * Output: 0
 * @Author gcc
 * @Date 18-11-22 下午2:34
 **/
public class 区间内的数全与的结果 {
    /**
     * For example, for number 26 to 30
     * Their binary form are:
     * 11010
     * 11011
     * 11100　　
     * 11101　　
     * 11110
     *
     * Because we are trying to find bit AND, so if any bit there are at least one 0 and one 1, it always 0
     *
     * 其实就是找到[m, n]这么多数中的公共部分,而如果m与n不相等的话,[m,n]这么多数相与之后,最后一位数肯定是0.
     * 所以不断地右移m与n,并比较,直到相等为止,剩下的就是公共部分.在将公共部分尾部的0还原得到结果.
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        if(m == 0){
            return 0;
        }
        //记录右移的次数,用于还原
        int count = 0;
        while(m != n){
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m<<count;
    }

    public static void main(String[] args) {
        System.out.println(new 区间内的数全与的结果().rangeBitwiseAnd(0, 1));
    }
}
