package array;

/**
 * https://leetcode.com/problems/can-place-flowers/description/
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 */

public class 相邻元素不能种花是否能种指定个数的花 {
    public boolean canPlaceFlowers(int[] nums, int n) {
        int num = 0;
        for (int i = 0; i < nums.length - 1 && num < n; i++) {
            if (nums[i] == 0) {
                int next = (i == nums.length - 1) ? 0 : nums[i + 1];
                int pre = (i == 0) ? 0 : nums[i - 1];
                if (next == 0 && pre == 0) {
                    num++;
                    nums[i] = 1;
                }
            }
        }
        return num == n;
    }
}
