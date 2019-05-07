package array;



/**
 * https://leetcode.com/problems/next-permutation/description/
 * 有n个数组成排列数，共有n！个。它们的排列顺序是按照递增的顺序的
 * 比如1，2，3；1，3，2；2，1，3；2，3，1；3，1，2；3，2，1。
 */
public class 下一个全排列 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int k=-1,l=-1;

        // 全排列是以递增排列的，找到下一个排列就是交换某些元素，使得新的排列比原排列大

        //要找出最大的k，使得nums[k] < nums[k+1],那么我们就从后往前找好了，只要能找到，循环就结束了
        // [k+1.n-1]是递减的
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                k = i;
                break;
            }
        }

        if (k == -1) {
            //说明是降序排列的
            reverse(nums, 0, nums.length - 1);
        } else {
            //从nums[k+1,n-1]中找到最小的比nums[k]大的元素，将其交换。因为nums[k+1,n-1]是递减的，所以从后往前找
            //然后将两元素交换，交换之后，nums[k+1,n-1]仍然是降序的，需要将其reverse，保证新的全排列增加的最小
            for (int i = nums.length - 1; i > k; i--) {
                if (nums[i] > nums[k]) {
                    l = i;
                    break;
                }
            }
            swap(nums, k, l);
            reverse(nums, k+1, nums.length-1);
        }
    }

    private void swap(int[] nums, int k, int l) {
        int temp = nums[k];
        nums[k] = nums[l];
        nums[l] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp2 = nums[start];
            nums[start] = nums[end];
            nums[end] = temp2;
            start++;end--;
        }
    }
    public static void main(String[] args) {
        int[] input = new int[]{3, 2, 1};
        new 下一个全排列().nextPermutation(input);
        for (int i=0; i<input.length; i++) {
            System.out.println(input[i]);
        }

    }
}
