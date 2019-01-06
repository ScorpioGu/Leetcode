package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc https://leetcode.com/problems/intersection-of-two-arrays-ii/Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 *
 * @Author gcc
 * @Date 19-1-6 下午3:51
 **/
public class 求两个数组的交集II {
    /**
     * 思考:如果nums1太大,nums2太大,无法全部载入内存,此时应该怎么办
     * 对nums1,nums2外部排序,每次读取各自的一个数,记录两个数是否相等
     * 因为已经排好序了,所以只遍历一遍不会遗漏
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        // 存每个数出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) != 0) {
                map.put(i, map.get(i) - 1);
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (Integer e : list) {
            res[i++] = e;
        }
        return res;
    }

}
