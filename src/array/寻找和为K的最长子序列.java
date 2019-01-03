package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc https://segmentfault.com/a/1190000005771068
 * @Author gcc
 * @Date 19-1-3 下午4:48
 **/
public class 寻找和为K的最长子序列 {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        //key为前缀和,value为坐标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                res = i + 1;
            } else if (map.containsKey(sum - k)) {
                res = Math.max(res, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return res;
    }
}
