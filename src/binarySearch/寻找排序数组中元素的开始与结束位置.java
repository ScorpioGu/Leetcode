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
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (nums[left] == target && nums[right] == target) {
                    return new int[]{left, right};
                } else if (nums[left] != target) {
                    left++;
                } else {
                    right--;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
