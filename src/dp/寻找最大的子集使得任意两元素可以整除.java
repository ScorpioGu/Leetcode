package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc https://leetcode.com/problems/largest-divisible-subset/
 * @Author gcc
 * @Date 19-1-8 下午4:53
 **/
public class 寻找最大的子集使得任意两元素可以整除 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        //count[i]表示以nums[i]结尾的最大子集的个数
        int[] count = new int[n];
        //pre[i]表示以nums[i]结尾的最大子集中,在nums[i]前面的那个元素
        //这个数组充当了一个链表的作用
        int[] pre = new int[n];
        int index = -1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            pre[i] = - 1;
            for (int j = 0; j < i; j++) {
                //是否要把新的一个新的元素添加到子集,只需要将新元素与原集合中的最大元素相除进行判断即可
                //如果能够整除,必然也能整除子集中其他的元素
                if (nums[i] % nums[j] == 0) {
                    if (count[j] + 1 > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        while (index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
}
