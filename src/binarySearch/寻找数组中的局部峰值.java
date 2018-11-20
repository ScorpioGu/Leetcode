package binarySearch;

/**
 * @Desc https://leetcode.com/problems/find-peak-element/description/
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 *              or index number 5 where the peak element is 6.
 * @Author gcc
 * @Date 18-11-19 下午9:43
 **/
public class 寻找数组中的局部峰值 {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right)/2;
            int mid2 = mid + 1;
            if (nums[mid] > nums[mid2]) {
                right = mid;
            } else {
                left = mid2;
            }
        }
        return right;
    }
}
