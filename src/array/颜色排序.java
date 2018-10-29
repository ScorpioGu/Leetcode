package array;

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
        //这两个指针记录最后一个0，1的位置
        int red = 0, white = 0;
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            nums[i] = 2;
            //不论是0还是1，white的位置都会向后移动
            if (v < 2) {
                //先暂时更改为1，随着red的增加，这里有可能更改为0的
                nums[white++] = 1;
            }
            if (v == 0) {
                //如果本来就是0，red指针向后移动即可
                nums[red++] = 0;
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
