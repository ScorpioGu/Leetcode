package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * @Desc https://leetcode.com/problems/longest-consecutive-sequence/description/
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * Your algorithm should run in O(n) complexity.
 * <p>
 * Example:
 * <p>
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * @Author gcc
 * @Date 18-11-13 上午10:33
 **/
public class 最长连续元素的长度 {
    /**
     * 记录每个位置的元素所能够形成的最长串的长度,对于连续的串来说,其中的每个元素所能形成的串的长度都一样
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        //因为使用HashSet存储,所以查找/删除的时间复杂度是o(1)
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        //看起来像是o(n^2)的时间复杂度,但实际上对连续的串,在访问其出现的第一个元素时,会去遍历这个连续串中的其他元素,并且将其从set中删除
        //因为对于连续串中的每个元素,其串长度是相同的.删除操作也保证了每个元素均只会被访问一次,时间复杂度为o(n)
        for (int i : nums) {
            set.remove(i);
            int left = i - 1, right = i + 1;
            while (set.remove(left)) {
                left--;
            }
            while (set.remove(right)) {
                right++;
            }
            max = Math.max(max, right - left - 1);
            if (set.isEmpty()) {
                return max;
            }
        }
        return max;
    }
}
