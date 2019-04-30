package greedy;

/**
 * @Desc https://leetcode.com/problems/jump-game-ii/description/
 * 数组存储是当前位置能够跳的最大距离，求跳到终点需要的最小跳数。
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * You can assume that you can always reach the last index.
 * @Author gcc
 * @Date 18-10-19 下午8:56
 **/
public class 跳跃游戏II {

    /**
     * 贪心思想，每一跳都求出最远能跳到哪里，假设最远跳到x处，则下一跳从x处寻找最远能跳到哪里。
     * BFS,每一轮挑出一颗最远的分支继续下一轮，其它分之不用管。
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0;
        int maxReach = 0;
        int hops = 0;
        int nextMax = 0;
        while (i < nums.length - 1) {
            hops++;
            for (; i <= maxReach; i++) {
                nextMax = Math.max(nextMax, nums[i] + i);
                if (nextMax >= nums.length - 1) {
                    return hops;
                }
            }
            maxReach = nextMax;
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(new 跳跃游戏II().jump(new int[]{2, 3, 1, 1, 4}));
    }
}
