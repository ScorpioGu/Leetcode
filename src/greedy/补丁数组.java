package greedy;

/**
 * @Desc https://leetcode.com/problems/patching-array/
 * @Author gcc
 * @Date 19-1-3 下午10:05
 **/
public class 补丁数组 {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int added = 0, i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                added++;
            }
        }
        return added;
    }
}
