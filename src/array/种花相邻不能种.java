package array;
/*
 * @Description Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: True


Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: False

 * @Date 下午9:01 18-9-6
 * @Param
 * @return
 **/
public class 种花相邻不能种 {
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
