package slide_window;

/**
 * @Desc
 * @Author gcc
 * @Date 19-5-29 下午4:25
 **/
public class 正数数组和为k的最长子数组 {
    // 正数数组保证了和在左右边界扩的时候的单调性，所以可以使用双指针

    int getManLen(int[] nums, int k) {
        int l = 0, r = 0;
        int sum = nums[r];
        int maxLen = 0;
        while (r < nums.length) {
            if (sum == k) {
                maxLen = Math.max(maxLen, r - l + 1);
                sum -= nums[l++];
            } else if (sum > k) {
                sum -= nums[l++];
            } else {
                r++;
                if (r == nums.length) {
                    break;
                }
                sum += nums[r];
            }
        }
        return maxLen;
    }
}
