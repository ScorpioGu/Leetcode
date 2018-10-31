package array;

import java.util.Arrays;

//原始的序列和排好序的序列相比，从头跟尾寻找连续的相同的元素。直到不相同，即为需要修改的序列
public class 改变一个最短子序列使整个序列升序 {
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        int i = 0, j = temp.length - 1;
        while (i < nums.length && nums[i] == temp[i]) {
            i++;
        }
        while (i < j && nums[j] == temp[j]) {
            j--;
        }
        return j - i + 1;
    }
}