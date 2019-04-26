package sort;

/**
 * @Desc https://leetcode.com/problems/sort-colors/description/
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,0,1,0]
 * Output: [0,0,0,1,1,2,2]
 * @Author gcc
 * @Date 18-10-29 下午5:02
 **/
public class 颜色排序 {
    /**
     * 要求one-pass的算法，并且in-place的空间复杂度
     * 因为我们知道希望的值就0,1,2三个，所以并不需要交换，赋值即可。
     * 双指针，所有0放最左边，所有2放最右边
     * @param nums
     */
    public void sortColors(int[] nums) {
        //这3个指针记录下一个0，1,2的应该插入的位置
        int index0 = 0, index1 = 0, index2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];

            // 需要注意的是当前还没有２，index2和index1是相同的，当前还没1，index1和index2是重复的
            // 所以注意赋值的顺序
            // nums[index2++] = 2;
            // nums[index1++] = 1;
            if (value == 2) {
                nums[index2++] = 2;
            } else if (value == 1) {
                nums[index2++] = 2;
                nums[index1++] = 1;
            } else {
                nums[index2++] = 2;
                nums[index1++] = 1;
                nums[index0++] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,0,1,0};
        new 颜色排序().sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
