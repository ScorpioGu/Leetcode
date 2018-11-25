package dp;

import java.util.Arrays;


/**
 * https://leetcode.com/problems/3sum-closest/description/
 */

public class 找出和最接近目标的三个数 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int local = Integer.MAX_VALUE, global = Integer.MAX_VALUE;
        int rtn = 0;
        for (int i = 2; i < nums.length; i++) {
            int temp = target - nums[i];
            int left = 0, right = i-1;
            int sum = 0;
            while (left < right) {
                if (Math.abs(nums[left] + nums[right] - temp) < local) {
                    local = Math.abs(nums[left] + nums[right] - temp);
                    sum = nums[i] + nums[left] + nums[right];
                }

                if ((nums[left] + nums[right] - temp) > 0) {
                    right--;
                } else {
                    left++;
                }
            }
            if (local < global) {
                global = local;
                rtn = sum;
            }
        }
        return rtn;
    }

    public static void main(String[] args) {
        System.out.println(new 找出和最接近目标的三个数().threeSumClosest(new int[]{0,2,1,-3}, 1));
    }
}
