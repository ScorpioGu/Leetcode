package array;


//https://leetcode.com/problems/next-permutation/description/

//有n个数组成排列数，共有n！个。它们的排列顺序是按照递增的顺序的
//比如1，2，3；1，3，2；2，1，3；2，3，1；3，1，2；3，2，1。

//来自维基百科上的一个求下一个排列数的算法
/*Find the largest index k such that nums[k] < nums[k + 1]. If no such index exists, the permutation is sorted in descending order, just reverse it to ascending order and we are done. For example, the next permutation of [3, 2, 1] is [1, 2, 3].
        Find the largest index l greater than k such that nums[k] < nums[l].
        Swap nums[k] and nums[l].
        Reverse the sub-array from nums[k + 1] to nums[nums.size() - 1]*/
public class 下一个全排列 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int k=-1,l=-1;
        //要找出最大的k，使得nums[k] < nums[k+1],那么我们就从后往前找好了，只要能找到，循环就结束了
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
            //要找出最大的l，使得nums[k] < nums[l],那么我们就从后往前找好了，只要能找到，循环就结束了
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
