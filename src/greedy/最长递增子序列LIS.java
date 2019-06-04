package greedy;

import java.util.Arrays;

/**
 * @Desc https://leetcode.com/problems/longest-increasing-subsequence/
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * Example:
 * <p>
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 * <p>
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 * <p>
 * 最长递增子序列LIS,只需要递增,而不需要连续.
 * @Author gcc
 * @Date 18-12-16 上午11:20
 **/
public class 最长递增子序列LIS {

    /**
     * 二分法
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //当前最长lis的长度,为了方便先将其减1
        int len = 0;
        //tails[i]表示长度为i+1的升序序列其末尾的数字,这个升序序列保证同长度的升序序列中,其末尾数字最小
        //因为末尾数字越小,越容易使得后面新元素加入时升序序列更长.
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        for (int num : nums) {
            //Arrays.binarySearch的返回值是如果能够找到返回索引
            //如果找不到则返回-插入的位置 -１
            //左闭右开
            int index = Arrays.binarySearch(tails, 0, len, num);
            if (index < 0) {
                index = -index + 1;
            }
            // 原位置一定是比num大的数，将其替换
            tails[index] = num;
            if (index == len) {
                //如果是在末尾修改了，则需要扩容一个长度
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(new 最长递增子序列LIS().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
