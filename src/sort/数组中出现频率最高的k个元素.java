package sort;

import java.util.*;

/**
 * @Desc https://leetcode.com/problems/top-k-frequent-elements/
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * @Author gcc
 * @Date 19-1-6 下午2:49
 **/
public class 数组中出现频率最高的k个元素 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //先记录一下各个数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //buckets[i]记录出现次数为ｉ的数的集合
        //之所以length为nums.length +１.是因为可能至少出现０次，最多出现nums.length次
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Integer key : map.keySet()) {
            if (buckets[map.get(key)] == null) {
                buckets[map.get(key)] = new ArrayList<>();
            }

            buckets[map.get(key)].add(key);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = nums.length; i >= 0 && res.size() < k ; i--) {
            if (buckets[i] != null) {
                res.addAll(buckets[i]);
            }
        }
        return res;
    }

    public List<Integer> topKFrequentByMaxHeap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //最大堆，堆顶元素一定是出现频率最高的元素，在构造方法中我们使用lamda表达式写了一个Comparator
        //使用Entry中的value(出现次数)作为比较依据
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);
        }

        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            res.add(maxHeap.poll().getKey());
        }

        return res;
    }
}
