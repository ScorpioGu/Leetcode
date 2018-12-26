package bit;

/**
 * @Desc https://leetcode.com/problems/single-number-iii/
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 *
 * Example:
 *
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * Note:
 *
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * @Author gcc
 * @Date 18-12-4 上午10:55
 **/
public class 求数组中仅出现过一次的元素III {
    public int[] singleNumber(int[] nums) {
        //先求出两数异或的结果，
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff ^= nums[i];
        }

        //因为两数不同，其异或之后必然存在某位为１，我们找到这个１所在的位，那么必然这两个数在该位上一个为０一个为１
        //那我们就找一下从低到高第一次１

        //在计算机中，负数存储是整数的反码+1，那将一个数与其相反数按位与的话
        //得到的就是整数从低到高第一个1.　比如6:0....110,其负数1....010，
        //按位与得到的是0.....010．
        diff &= -diff;

        //然后再将数组分两部分，一部门是该位为１的，一部分是该位为０的，要求的两树必然被分在两个不同的部分
        //而数组中其他相同的数必然被分在同一个部分
        //这样，每部分就转化成了singleNumberI的情形

        int[] res = {0, 0};
        for (int num : nums) {
            if ((num & diff) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }

}
