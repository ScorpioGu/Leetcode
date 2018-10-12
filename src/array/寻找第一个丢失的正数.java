package array;

/**
 * @Desc https://leetcode.com/problems/first-missing-positive/description/
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 *
 * @Author gcc
 * @Date 18-10-10 下午4:39
 **/
public class 寻找第一个丢失的正数 {
    /**
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        //把所有处于【1，N】的i，放到nums【i-1】处，比如5放在nums【4】处
        //这样过后，从坐标0开始，在不缺失的情况下应该时1，i处应该时i+1。
        //如果不相等，说明i+1这个数缺失。并且我们从0开始向后遍历，保证了第一个找到的就是最小的丢失的正数
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] >= 1 && nums[i]<=nums.length && nums[nums[i]-1] != nums[i]) {
                //注意此处交换不能成下面这样
/*                int temp = nums[i];
                nums[i] = nums[nums[i] - 1]; //此处nums[i]重新赋值了
                nums[nums[i] - 1] = temp;*/  //nums[nums[i] - 1]引用了一个修改后的nums[i]，可能会导致数组越界

                //这样写法就没有问题，因为nums[i]并不依赖nums[nums[i] - 1]，先修改nums[nums[i] - 1]不会对nums[i]产生影响
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        //如果进行到这一步，说明交换后的数组中的数都是从1开始的连续整数，那么丢的就是nums.length+1
        return nums.length+1;
    }
}
