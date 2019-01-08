package dp;

/**
 * @Desc https://leetcode.com/problems/wiggle-subsequence/
 * A sequence of numbers is called a wiggle sequence if the differences
 * between successive numbers strictly alternate between positive and
 * negative. The first difference (if one exists) may be either positive
 * or negative. A sequence with fewer than two elements is trivially a
 * wiggle sequence.
 * <p>
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differen
 * ces (6,-3,5,-7,3) are alternately positive and negative. In contrast,
 * [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first
 * because its first two differences are positive and the second because
 * its last difference is zero.
 * <p>
 * Given a sequence of integers, return the length of the longest
 * subsequence that is a wiggle sequence. A subsequence is obtained
 * by deleting some number of elements (eventually, also zero) from
 * the original sequence, leaving the remaining elements in their
 * original order.
 * @Author gcc
 * @Date 19-1-8 下午9:06
 **/
public class 最长的摆动子序列 {
    /**
     * 动态规划,某一点处的状态可能有两个,上升和下降
     * 使用up[i],down[i]保存序列[nums[0], ..., nums[i]]两个状态下的最大摆动子序列长度,新来一个元素之后
     * 其up[i+1],down[i+1]必然来自于up[i],down[i]
     *
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }

        return Math.max(up[nums.length - 1], down[nums.length - 1]);
    }
}
