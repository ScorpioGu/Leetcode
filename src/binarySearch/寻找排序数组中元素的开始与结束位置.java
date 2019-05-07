package binarySearch;

/**
 * @Desc https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * @Author gcc
 * @Date 18-10-8 下午9:54
 **/
public class 寻找排序数组中元素的开始与结束位置 {
    public int[] searchRange(int[] nums, int target) {
        int start = getFirstGreaterEqual(nums, target);

        // 如果没找到直接返回了
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1,-1};
        }

        return new int[]{start, getFirstGreaterEqual(nums, target  + 1) - 1};

    }

    /**
     * 寻找第一个大于等于target的元素的坐标
     * 注意与  寻找target应该插入的位置  做法不同
     * 若nums中有多个连续的target，比如8888，那么 寻找target应该插入的位置 返回的结果可能是任意一个8的位置
     * 而此处必须要返回第一个8的位置
     * @param nums
     * @param target
     * @return
     */
    private int getFirstGreaterEqual(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int m = l + ((r - l) >>> 1);
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }


}
