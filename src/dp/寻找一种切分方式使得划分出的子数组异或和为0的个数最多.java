package dp;

import java.util.HashMap;

/**
 * @Desc
 * 比如[1 2 3 0 1 2 3 0]
 * 最好的一种划分方式是 123 0 123 0,共4个
 * @Author gcc
 * @Date 19-5-27 下午10:29
 **/
public class 寻找一种切分方式使得划分出的子数组异或和为0的个数最多 {
    public static int mostEOR(int[] arr) {
        int ans = 0;
        int xor = 0;
        //mosts[i]表示以arr[i]结尾的数组的局部最优解
        int[] mosts = new int[arr.length];
        // 存储前缀异或和和出现的下标
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            // 这种情况包含i的最后一段，通过切割，异或和为0
            if (map.containsKey(xor)) {
                //如果前缀和曾经出现过，曾经出现的坐标为pre,根据异或0^n=n的性质，从pre+1到i这一段，一定是异或和为0
                int pre = map.get(xor);
                mosts[i] = pre == -1 ? 1 : (mosts[pre] + 1);
            }
            // 这种情况，包含i的最后一段，异或和不为0，那么就是增加了这个字符，异或和为0的个数并没有增加，mosts[i]可以来自于most[i-1]
            if (i > 0) {

                // 取两种情况下的较大值
                mosts[i] = Math.max(mosts[i - 1], mosts[i]);
            }
            // 如果之前存在过xor，也是要更新的，这个看具体题目要求决定是更新还是不更新
            map.put(xor, i);
            ans = Math.max(ans, mosts[i]);
        }
        return ans;
    }
}
