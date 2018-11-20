package sort;

import java.util.Arrays;

/**
 * @Desc https://leetcode.com/problems/maximum-gap/description/
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 *
 * Return 0 if the array contains less than 2 elements.
 *
 * Example 1:
 *
 * Input: [3,6,9,1]
 * Output: 3
 * Explanation: The sorted form of the array is [1,3,6,9], either
 *              (3,6) or (6,9) has the maximum difference 3.
 *
 * Note:
 *
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 * Try to solve it in linear time/space.
 * @Author gcc
 * @Date 18-11-19 下午10:01
 **/
public class 求数组在排好序时相邻元素最大差值 {
    /**
     * 要求线性的时间空间复杂度,那就用通排序或者基数排序来做吧
     * @param num
     * @return
     */
    public int maximumGap(int[] num) {
        if (num == null || num.length < 2) {
            return 0;
        }
        int min = num[0];
        int max = num[0];
        for (int i:num) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        //ceil是向上取整,这是一个桶存放的区间.而最大间距一定是大于这个值的,所以两个数一定是存在两个不同的桶中的
        int gap = (int)Math.ceil((double)(max - min)/(num.length - 1));
        //初始化桶,桶内只需要存放两个元素,区间内的最大值与最小值,对于第i个桶,它存的元素放到bucketsMIN[i]与bucketsMAX[i]
        //但是最大值与最小值不放到桶里
        int[] bucketsMIN = new int[num.length - 1];
        int[] bucketsMAX = new int[num.length - 1];
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
        for (int i:num) {
            if (i == min || i == max)
                continue;
            int idx = (i - min) / gap;
            bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
            bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
        }
        // scan the buckets for the max gap
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < num.length - 1; i++) {
            //n-2个元素放到n-1桶里面肯定会有空桶的
            if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE)
                // empty bucket
                continue;
            // min value minus the previous value is the current gap
            maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
            // update previous bucket value
            previous = bucketsMAX[i];
        }
        // updata the final max value gap
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }

    /**
     * 用基数排序来做
     * @param num
     * @return
     */
    public int maximumGap2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        // m is the maximal number in nums
        int m = nums[0];
        for (int i = 1; i < nums.length; i++) {
            m = Math.max(m, nums[i]);
        }

        int[] tmp = new int[nums.length];
        int exp = 1;
        while (m / exp > 0) {
            int[] count = new int[10];
            for (int i = 0; i < nums.length; i++) {
                count[(nums[i] / exp) % 10]++;
            }

            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            for (int i = nums.length-1; i >= 0 ; i--) {
                tmp[--count[(nums[i] / exp) % 10]] = nums[i];
            }

            for (int i = 0; i < nums.length; i++) {
                nums[i] = tmp[i];
            }

            exp *= 10;
        }
        int maxGap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
        }
        return maxGap;
    }
}
