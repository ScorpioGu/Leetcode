package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Desc https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 *
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 *
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 *
 * Example 1:
 *
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence:
 *              [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 *
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [1,1],[1,1]
 * Explanation: The first 2 pairs are returned from the sequence:
 *              [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * @Author gcc
 * @Date 19-1-8 下午7:41
 **/
public class 从两有序数组中选出k对使得和最小 {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return res;
        }
        //q只存放可能成为结果的的pair,比如(nums1[0], nums2[k])就不需要添加到队列中的,因为必然它不可能是最小的k个
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        //对于任意的nums[i],它最好的搭档都是nums2[0]
        for (int i = 0; i < k && i < nums1.length; i++) {
            //int[1] 存放nums2中的值,int[2]存放nums2中下标
            q.offer(new int[]{nums1[i], nums2[0], 0});
        }
        //而对于某一个对(nums1[i], nums2[j]),则它下个可能的pair是(nums1[i], nums2[j+1]),在j+1不越界的情况
        while (k-- > 0 && !q.isEmpty()) {
            int[] cur = q.poll();
            res.add(new int[]{cur[0], cur[1]});
            if (cur[2] == nums2.length - 1) {
                continue;
            }
            q.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return res;
    }

}
