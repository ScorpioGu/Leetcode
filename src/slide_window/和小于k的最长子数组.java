package slide_window;

/**
 * @Desc 给的数组可正可0可负，那么和是没有单调性的，左右边界扩，可都有可能增大和减少，所以不能够直接使用双指针
 * @Author gcc
 * @Date 19-5-29 下午4:27
 **/
public class 和小于k的最长子数组 {
    // minSum[i]表示以nums[i]开头的所有子数组的最小累加和，必须包含nums[i]
    // int[] minSum
    // 以nums[i]开头的取得最小累加和的子数组的右边界
    // int[] minSumIndex
    int maxLengthAwesome(int[] nums, int k) {
        int len = nums.length;
        int[] minSum = new int[len];
        int[] minSumIndex = new int[len];
        minSum[len - 1] = nums[len - 1];
        minSumIndex[len - 1] = len - 1;
        for (int i = len - 2; i >= 0 ; i--) {
            if (minSum[i + 1] > 0) {
                minSum[i] = nums[i];
                minSumIndex[i] = i;
            } else {
                minSum[i] = nums[i] + minSum[i + 1];
                minSumIndex[i] = minSumIndex[i + 1];
            }
        }
        int l = 0, r = 0;
        int sum = 0;
        int maxLen = 0;
        while (r < nums.length) {
            // from valid to invalid
            while (r < nums.length && sum + minSum[r] <= k) {
                sum += minSum[r];
                r = minSumIndex[r] + 1;
            }
            // [l,r-1]
            maxLen = Math.max(maxLen, r - l);
            if (r > l) {
                sum -= nums[l++];
            } else {
                // [100,200,-8,-2] aim = 6, in case like this, when r = 0, l = 0,wo need to set r = 1, l = 1
                r = ++l;
            }
        }
        return maxLen;
    }
}
