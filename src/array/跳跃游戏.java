package array;

/**
 * @Desc https://leetcode.com/problems/jump-game/description/
 * 输入时一个数组，每个元素代表当前位置最远可以跳多长，判断是否能够调到最后一个位置
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * @Author gcc
 * @Date 18-10-19 下午8:13
 **/
public class 跳跃游戏 {

    /**
     * 变为子问题，从后往前推，如果i位置能够跳到j位置，那能否跳到j位置就转化为了能否跳到i位置。
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        return helper(nums, nums.length - 1);
    }

    private boolean helper(int[] nums, int desIndex) {
        if (desIndex == 0) {
            return true;
        }
        for(int i=desIndex-1; i>=0; i--) {
            if (desIndex - i <= nums[i]) {
                return helper(nums, i);
            }
        }
        return false;
    }

    /**
     * 贪心的思想，因为数组存储的是最大能够跳的长度，那么如果能够跳到k处，则前k-1
     * 个位置一定能够到达。那么能够跳到数组的最后一个位置，则可以维护一个当前能够跳的最远距离的变量
     * 当该值大于等于数组长度-1时返回true即可
     *
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxReach >= i) {
                maxReach = Math.max(maxReach, i + nums[i]);
                if (maxReach >= nums.length-1) {
                    return true;
                }
            }
        }
/*        System.out.println(maxReach);
        return maxReach == nums.length-1;*/
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new 跳跃游戏().canJump2(new int[]{3,2,1,0,4}));
    }
}
