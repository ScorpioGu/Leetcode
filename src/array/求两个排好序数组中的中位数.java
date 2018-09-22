package array;

//如果是奇数，返回中间的即可，否则去中间两元素和再除2
//https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2481/Share-my-O(log(min(mn))-solution-with-explanation
/*Searching i in [0, m], to find an object `i` that:
        B[j-1] <= A[i] and A[i-1] <= B[j], ( where j = (m + n + 1)/2 - i )*/
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

        int left = 0, right = len1-1, half_len = (len1 + len2 + 1)/2;
        while (left <= right) {
            int i = (left+right)/2;
            int j = half_len - i;
            if (i < len1 &&nums1[i] >= nums2[j-1] ) {
                //TODO
            }
        }
    }
}
