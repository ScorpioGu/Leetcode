package twopointers;

/**
 * @Desc https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 * Given nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3
 * @Author gcc
 * @Date 18-10-31 下午8:04
 **/
public class 有序数组中删除重复元素II {
    /**
     * 要求in-place空间复杂度，必须对nums进行修改，并返回新数组长度
     * @param nums 输入数组
     * @return 新数组的长度
     */
    public int removeDuplicatesII(int[] nums) {
        if (nums == null) {
            return -1;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int index = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
                if (count <= 2) {
                    nums[index++] = nums[i];
                }
            } else {
                nums[index++] = nums[i];
                count = 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] res = {1, 1, 1, 2, 2, 3};
        int len = new 有序数组中删除重复元素II().removeDuplicatesII(res);
        System.out.println(len);
        for (int i:res) {
            System.out.println(i);
        }
    }
}
