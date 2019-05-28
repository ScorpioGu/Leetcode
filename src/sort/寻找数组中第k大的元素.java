package sort;

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
     * 寻找到第k大的元素,前两种做法都是对整个数组进行排序
     * 但是寻找第k大的元素,并不需要前k-1整体排好序.只要所有元素小于第k个就行了
     * 使用快排实现
     *
     * 期望是o(n)，但是最坏情况是o(n^2)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        //第k大的元素的位置在nums.length - k下标
        k = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int[] p = partition(nums, left, right);
            if (k < p[0]) {
                right = p[0] - 1;
            } else if (k > p[1]) {
                left = p[1] + 1;
            } else {
                return nums[p[0]];
            }
        }
        return nums[left];
    }

    public static int[] partition(int[] nums, int l, int r) {
        int less = l - 1;
        int more = r + 1;
        int ref = nums[r];
        // ref选为nums[r]
        while (l < more) {
            if (nums[l] < ref) {
                //因为l是大于less的，less+1处肯定已经被访问过了，并且等于ref
                //交换过来之后，没有必要对这个换过来的元素再进行判断了，所以可以l++
                swap(nums, ++less, l++);
            } else if (nums[l] > ref) {
                //这种情况下交换过来的元素还没有被访问过，所以交换过来还要比较一次，所以不能l++
                swap(nums, --more, l);
            } else {
                l++;
            }
        }
        return new int[] {less + 1, more - 1};
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
