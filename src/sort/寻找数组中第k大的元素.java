package sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @Desc https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * @Author gcc
 * @Date 18-11-26 上午10:50
 **/
public class 寻找数组中第k大的元素 {
    /**
     * 最简单的方法就是排序的话时间复杂度o(nlogn)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }


    /**
     * 利用优先级队列,将时间复杂度降为o(Nlogk),因为队列的长度不超过k
     * 所以每次插入一个元素,耗费的时间平均为logk.
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        //优先级队列存储int时,默认较小元素放队列头
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    /**
     * 寻找到第k大的元素,前两种做法都是对整个数组进行排序
     * 但是寻找第k大的元素,可以并不需要前k-1排好序.
     * 使用快排实现
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest3(int[] nums, int k) {
        shuffle(nums);
        //第k大的元素的位置在nums.length - k下标
        k = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = getMiddle(nums, left, right);
            if (mid == k) {
                return nums[k];
            } else if (mid > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    /**
     * @param nums
     * @param head
     * @param tail
     * @return
     */
    private int getMiddle(int[] nums, int head, int tail) {
        int ref = nums[head];
        while (head < tail) {
            while (head < tail && nums[tail] >= ref) {
                tail--;
            }
            nums[head] = nums[tail];
            while (head < tail && nums[head] <= ref) {
                head++;
            }
            nums[tail] = nums[head];
        }
        nums[head] = ref;
        return head;
    }

    /**
     * 对输入进行随机化处理,避免最坏的情况
     * @param nums
     */
    private void shuffle(int nums[]) {
        Random random = new Random();
        for(int i = 1; i < nums.length; i++) {
            //nextInt(r)取随机数[0,r)
            final int r = random.nextInt(i + 1);
            int temp = nums[r];
            nums[r] = nums[i];
            nums[i] = temp;
        }
    }
}
