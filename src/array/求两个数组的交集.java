package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Desc https://leetcode.com/problems/intersection-of-two-arrays/
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 * @Author gcc
 * @Date 19-1-6 下午3:38
 **/
public class 求两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> insSet = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }

        for (int i : nums2) {
            if (set.contains(i)) {
                insSet.add(i);
            }
        }

        int[] res = new int[insSet.size()];
        int i = 0;
        for (Integer e : insSet) {
            res[i++] = e;
        }
        return res;
    }
}
