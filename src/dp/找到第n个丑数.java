package dp;

/**
 * @Desc https://leetcode.com/problems/ugly-number-ii/
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 *
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 *
 *
 * @Author gcc
 * @Date 18-12-20 下午8:29
 **/
public class 找到第n个丑数 {
    /**
     * 丑数可以拆分成下面三个子列表
     (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
     (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
     (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
     丑数就是在这三行中,根据大小一个一个挑出来的

     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        int index2 = 0, index3 = 0, index5 = 0;
        nums[0] = 1;
        for(int i = 1; i < nums.length; i++){
            nums[i] = Math.min(nums[index2] * 2, Math.min(nums[index3] * 3, nums[index5] * 5));
            // 注意这里不可以用if else，这是为了避免重复，比如６＝２＊３＝３＊２，那么 index2与index3都要++
            if(nums[i] == nums[index2] * 2) {
                index2++;
            }
            if(nums[i] == nums[index3] * 3) {
                index3++;
            }
            if(nums[i] == nums[index5] * 5) {
                index5++;
            }
        }
        return nums[n - 1];
    }
}
