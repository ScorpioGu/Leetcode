package binarySearch;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 * 画画图就ok
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 */
public class 寻找旋转后排序数组中元素 {
    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[right]) {
                //左半边一定是有序的,如果target在这个左半边有序的区间内,则right变为mid-1,否则一定是在右半边,left = mid + 1
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //右半边一定是有序的
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new 寻找旋转后排序数组中元素().search(new int[]{1,3}, 3));
    }
}
