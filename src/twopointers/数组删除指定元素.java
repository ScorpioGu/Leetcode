package twopointers;

/**
 * @Desc https://leetcode.com/problems/remove-element/
 * Given nums = [3,2,2,3], val = 3,
 *
 * Your function should return length = 2, with the first two elements of nums being 2.
 *
 * It doesn't matter what you leave beyond the returned length.
 *
 * @Author gcc
 * @Date 19-5-8 上午9:52
 **/
public class 数组删除指定元素 {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
