package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 *
 * Example:
 *
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 *
 * 剑指offer上有一题,求nums中逆序对的个数,也是通过归并排序来做的
 * https://www.nowcoder.com/questionTerminal/96bd6684e04a44eb80e6a68efc0ec6c5
 *
 * @Author gcc
 * @Date 18-12-25 上午10:21
 *
 **/
public class 逆序对个数II {
    int[] count;

    /**
     * 对nums进行归并排序,但是排序的对象是索引,原数组保持不变
     * 保存索引数组是为了保存结果
     * Example: nums = [5,2,6,1], index = [0,1,2,3]
     * After sort: indexes = [3,1,0,2]
     * 在归并排序的过程中,右边数组加入到新数组时,rightCount++,表示此时从右边数组加进来的个数
     * 左边数组中加入新数组时,用元素原来的count[]累加rightCount,
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        count = new int[nums.length];
        // index[i] 表示nums[i]当前的排在nums中rank
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }

        mergeSort(nums, index, 0, nums.length-1);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            res.add(count[i]);
        }
        return res;
    }

    private void mergeSort(int[] nums, int[] index, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left)/2;
        mergeSort(nums, index, left, mid);
        mergeSort(nums, index, mid + 1, right);
        merge(nums, index, left, mid,right);
    }

    private void merge(int[] nums, int[] index, int left, int mid, int right) {
        int[] newIndex = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int rightCount = 0;
        while (i <= mid && j <= right) {
            if (nums[index[i]] <= nums[index[j]]) {
                //从左边数组中添加一个元素
                // 新数组中从右半边添加的元素都是原数组中在它之后且比它小的,用rightCount记录
                //新数组中若添加的顺序若为l r l r r l 则rightcount变化为0 1 1 2 3 3,l r表示元素来自于左半边还是右半边
                count[index[i]] += rightCount;
                newIndex[k++] = index[i++];
            } else {
                //从右边数组中添加一个元素
                rightCount++;
                newIndex[k++] = index[j++];
            }
        }

        while (i <= mid) {
            count[index[i]] += rightCount;
            newIndex[k++] = index[i++];
        }

        while (j <= right) {
            newIndex[k++] = index[j++];
        }

        for (int l = 0; l < newIndex.length; l++) {
            index[l + left] = newIndex[l];
        }
    }


    // TODO 利用树状数组
}
