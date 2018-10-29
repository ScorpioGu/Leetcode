package BinarySearch;

/**
 * @Desc https://leetcode.com/problems/search-insert-position/description/
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * @Author gcc
 * @Date 18-10-29 下午4:31
 **/
public class 寻找元素在有序数组中应该插入的位置 {
    /**
     * 数组中没有重复元素，如果数组中存在目标元素返回其下标，不存在则返回它插入之后的坐标
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int begin = 0, end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return begin;
    }
}
