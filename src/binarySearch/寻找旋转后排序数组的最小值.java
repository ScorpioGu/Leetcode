package binarySearch;

/**
 * @Desc https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 *
 * Example 1:
 *
 * Input: [3,4,5,1,2]
 * Output: 1
 * @Author gcc
 * @Date 18-11-19 上午9:56
 **/
public class 寻找旋转后排序数组的最小值 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0, right = nums.length - 1;
        //什么时候是<=呢,什么时候是<呢?
        //当<=时,while循环中会出现left和right指针重复在一起的情况,这意味着查找元素在while循环中解决.当跳出循环之后,left会在right的右边
        //当<时,while循环中主要起一个将left和right靠拢的作用,当跳出循环之后,left和right一定是聚在一起的,而这就是需要查找的元素.
        //所以可以发现,使用<=一般是要查找已知的元素值,而<用于查找未知元素值但是元素需要满足一定条件的情况.
        while (left < right) {
            if (nums[left] < nums[right]) {
                //对于大多数情况,是从这里返回的,类似于34512
                //但是也有没有right大于left的情况,恰好最小的元素在最末端,类似于3451,这种情况需要在跳出循环之后返回
                return nums[left];
            }
            int mid = (left + right) / 2;
            //到这里了一定是两条单调离散序列的情况,最左边的元素一定不是最小值,left可以mid+1,而right则可能是最小值
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[right];
    }

    public static void main(String[] args) {
        System.out.println(new 寻找旋转后排序数组的最小值().findMin(new int[]{3,4,5,1,2}));
    }
}
