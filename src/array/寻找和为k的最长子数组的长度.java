package array;

import java.util.HashMap;

/**
 * @Desc https://segmentfault.com/a/1190000005771068
 * @Author gcc
 * @Date 19-1-3 下午4:48
 **/
public class 寻找和为k的最长子数组的长度 {
    public static int maxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // key为前缀和，value为第一次这个前缀和出现的对应子数组中最后一个元素的坐标
        HashMap<Integer, Integer> map = new HashMap();
        // 这个一定要加上，元素为0第一次出现的次数为-1
        // 比如1，2，3，-6,8，k=8
        // 如果不加这一行，找到的子数组就是8，如果加了这一行，找到的子数组才是1，2，3，-6,8
        map.put(0, -1);
        int len = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                // r = i, l = map.get(sum - k) + 1, len = r - l + 1
                len = Math.max(i - map.get(sum - k), len);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            // 如果重复出现了这个sum，只记录最早出现的位置，这是因为我们要求最长的子数组
        }
        return len;
    }
}
