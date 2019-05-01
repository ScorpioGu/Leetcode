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
        int step = 0;
        int end = 0;
        int maxReach = 0;

        // start代表当前位置，end代表当前可以跳的最远的位置，maxReach代表下一跳可以跳到的最远的位置。
        // 则在[start, end]中不断对maxReach更新，如果i走到了end位置，那么这一跳结束进入下一跳
        // 更新end为maxReach
        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == end) {
                step++;
                end = maxReach;
            }
        }
        return step;
    }


    public static void main(String[] args) {
        System.out.println(new 跳跃游戏II().jump(new int[]{2, 3, 1, 1, 4}));
    }
}
