package array;

/**
 * @Desc https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * @Author gcc
 * @Date 18-10-31 下午8:15
 **/
public class 有序数组中删除重复元素 {
    /**
     * 快慢指针，慢指针保留当前有效数组的长度，快指针负责遍历
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return -1;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
