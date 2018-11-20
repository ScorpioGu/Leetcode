package binarySearch;

/**
 * @Desc https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 *
    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

    (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

    Find the minimum element.

    The array may contain duplicates.

    Example 1:

    Input: [1,3,5]
    Output: 1
    Example 2:

    Input: [2,2,2,0,1]
    Output: 0
 *
 * @Author gcc
 * @Date 18-11-19 上午10:35
 **/
public class 寻找旋转后排序数组中的最小值II {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                //例如{2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 2} 和 {2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2}，
                //我们发现，当第一个数字和最后一个数字，还有中间那个数字全部相等的时候，二分查找法就崩溃了，因为它无法判断到底该去左半边还是右半边
                //但是我们可以将右边界去掉一个(我这种写法下nums[mid] = nums[right]),因为去掉的是相同的,所以对最终结果不会产生影响
                right--;
            }
        }
        return nums[right];
    }
    public static void main(String[] args) {
        System.out.println(new 寻找旋转后排序数组中的最小值II().findMin(new int[]{10, 1, 10, 10, 10}));
    }
}
