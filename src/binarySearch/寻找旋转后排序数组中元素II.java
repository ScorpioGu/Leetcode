package binarySearch;

/**
 * @Desc https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 * 与搜寻旋转后排序数组中元素二分法那题的不同之处在于数组中可以有重复元素
 * Example 1:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 *
 * @Author gcc
 * @Date 18-10-31 下午9:37
 **/
public class 寻找旋转后排序数组中元素II {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > nums[right]) {
                //左半边是升序的
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[right]) {
                //右半边是升序的
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                //此时nums[mid] = nums[right]，将right一直左移直到nums[mid] != nums[right]
                right--;
            }
        }
        return false;
    }
}
