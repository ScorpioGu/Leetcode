package BinarySearch;

/**
 * @Desc https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * @Author gcc
 * @Date 18-10-8 下午9:54
 **/
public class 排序数组中寻找元素的开始与结束位置二分法 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length-1;
        int[] res = new int[2];
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                //找到左右两个边界
                int templeft = left;
                int tempright = mid - 1;
                while (templeft <= tempright) {
                    int tempmid = (templeft + templeft)/2;
                    if (nums[tempmid] == target) {
                        tempright = tempmid - 1;
                    } else {
                        templeft = tempmid + 1;
                    }
                }
                res[0] = templeft;

                templeft = mid + 1;
                tempright = right;
                while (templeft <= tempright) {
                    int tempmid = (templeft + templeft)/2;
                    if (nums[tempmid] == target) {
                        templeft = tempmid + 1;
                    } else {
                        tempright = tempmid - 1;
                    }
                }
                res[1] = tempright;
                return res;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] res = new 排序数组中寻找元素的开始与结束位置二分法().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 5);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
