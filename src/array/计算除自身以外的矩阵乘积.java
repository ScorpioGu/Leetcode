package array;

/**
 * @Desc https://leetcode.com/problems/product-of-array-except-self/
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 * @Author gcc
 * @Date 18-12-3 上午11:09
 **/
public class 计算除自身以外的矩阵乘积 {
    /**
     * 题目规定了不可以使用除法运算,那么计算res[i]时就是要计算(nums[0]*nums[1]*...*nums[i-1]) * (nums[i+1]*...*nums[nums.length-1])
     * 对于每一个数,这样算一下,时间复杂度就变成了o(n^2).其实如果我们为每一个res[i]先算左边部分,再算右边部分是可以充分利用之前运算的信息的
     * 第一遍从左往右遍历,res[i]存放的是nums[0]*nums[1]*...*nums[i-1],显然可以得出res[i] = res[i - 1] * nums[i - 1];
     * 而从右往左遍历,则需要一个辅助的变量right来帮助存储当前位置右边的所有树的乘积,那么有res[i] *= right,那么左右两部分都乘了得到最终结果.
     * 边界两点只有其中一部分,另一部分为1
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int right = nums[nums.length - 1];
        for (int i = nums.length - 2; i >=0 ; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
