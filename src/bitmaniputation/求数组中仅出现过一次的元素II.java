package bitmaniputation;

/**
 * @Desc https://leetcode.com/problems/single-number-ii/description/
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,3,2]
 * Output: 3
 * @Author gcc
 * @Date 18-11-15 下午10:29
 **/
public class 求数组中仅出现过一次的元素II {
    /**
     * https://www.cnblogs.com/grandyang/p/4263927.html
     * @param A
     * @return
     */
    public int singleNumber(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
        }
        return ones;
    }
}
