package sort;

import java.util.Random;

/**
 * @Desc https://leetcode.com/problems/wiggle-sort-ii/
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 *
 * Example 1:
 *
 * Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 * Example 2:
 *
 * Input: nums = [1, 3, 2, 2, 3, 1]
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 * Note:
 * You may assume all input has valid answer.
 *
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 * @Author gcc
 * @Date 19-1-3 下午3:51
 **/
public class 摆动排序II {
    /**
     * 找到中位数,然后把中位数放第一个,所有比中位数的放在奇数位置,比中位数大的放在偶数位置
     * TODO 其实还是不是很懂啊,第二遍再看吧
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        int median = findKthLargest3(nums, (nums.length + 1)/2);
        int n = nums.length;
        int left = 0, i = 0, right = n - 1;

        while (i <= right) {

            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }
    }

    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

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
