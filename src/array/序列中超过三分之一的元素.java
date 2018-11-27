package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc　https://leetcode.com/problems/majority-element-ii/description/
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Note: The algorithm should run in linear time and in O(1) space.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 *
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 * @Author gcc
 * @Date 18-11-27 上午10:16
 **/
public class 序列中超过三分之一的元素 {
    /**
     * 序列中超过1/3的元素最多有两个．使用Moore voting算法
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int m = 0, n = 0, cm = 0, cn = 0;
        for (int num : nums) {
            if (m == num) {
                cm++;
            } else if (n == num) {
                cn++;
            } else if (cm == 0) {
                m = num;
                cm = 1;
            } else if (cn == 0) {
                n = num;
                cn = 1;
            } else {
                cm--;cn--;
            }
        }

        cm = 0;
        cn = 0;
        for (int num : nums) {
            if (num == m) {
                cm++;
            } else if (num == n) {
                cn++;
            }
        }

        if (cm > nums.length/3) {
            res.add(m);
        }
        if (cn > nums.length/3 && m != n) {
            res.add(n);
        }
        return res;
    }
}
