package binarySearch;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 * //如果是奇数，返回中间的即可，否则取中间两元素和再除2
 * //https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2481/Share-my-O(log(min(mn))-solution-with-explanation
 * //中位数可以将左边数组的长度与右边数组的长度变为相同，所以用两个指针在两数组上移动，一定是耗时的。
 * //一旦其中一个数组的指针位置确定，另外一个也必然是确定的。
 * Searching i in [0, m], to find an object `i` that:
 *         B[j-1] <= A[i] and A[i-1] <= B[j], ( where j = (m + n + 1)/2 - i )
 */
public class 求两个排好序数组中的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        //保证nums1是较小的那个数组
        if (len1 > len2) {
            int[] temp = nums1;
            int templen = len1;
            nums1 = nums2;
            nums2 = temp;
            len1 = len2;
            len2 = templen;
        }
        int left = 0, right = len1, half_len = (len1 + len2 + 1) / 2;
        while (left <= right) {
            int i = (left + right) / 2;
            int j = half_len - i;
            //不包含最左边
            if (i < len1 && nums2[j - 1] > nums1[i]) {
                left = i + 1;
                //不包含最右边
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                int maxLeft, minRight;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((len1 + len2) % 2 == 1) {
                    return maxLeft;
                }
                if (i == len1) {
                    minRight = nums2[j];
                } else if (j == len2) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }

                return (minRight + maxLeft) / 2.0;
            }
        }
        //没用
        return 0;
    }
}
