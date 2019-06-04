package dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Desc https://leetcode.com/problems/frog-jump/
 * Given a linklist of stones' positions (in units) in sorted ascending order,
 * determine if the frog is able to cross the river by landing on the last
 * stone. Initially, the frog is on the first stone and assume the first
 * jump must be 1 unit.
 *
 * If the frog's last jump was k units, then its next jump must be either
 * k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.
 * @Author gcc
 * @Date 19-1-15 上午10:52
 **/
public class 青蛙过河问题 {
    public boolean canCross(int[] stones) {
        int len = stones.length;
        // dp[i][j]代表第i个石头能否走k步
        // 步数最大值设为len的原因是最大步数从第1个是否跳到最后一个石头len-1,一共是len-1步,加1变成len步
        boolean[][] dp = new boolean[len][len + 1];
        // 第0个石头默认只能走1步
        dp[0][1] = true;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                // 探究从j能否跳到i
                int diff = stones[i] - stones[j];
                // diff[j][diff]如果是false,则表示不能一步从j跳到i,注意防止数组越界
                if (diff < 0 || diff > len || !dp[j][diff]) {
                    continue;
                }
                //如果能跳到最后一个石头,就已经成功了,最后一个石头的dp可以不用更新
                if (i == len - 1) {
                    return true;
                }

                //更新dp
                if (diff - 1 >= 0) {
                    dp[i][diff - 1] = true;
                }
                dp[i][diff] = true;
                if (diff + 1 < len + 1) {
                    dp[i][diff + 1] = true;
                }
            }
        }
        return false;
    }

    public boolean canCross2(int[] stones) {

        // 存放每个石头的位置以及它下一跳可以选择的所有步长
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(1);

        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            for (Integer step : map.get(stone)) {
                int reach = stone + step;
                if (reach == stones[stones.length - 1]) {
                    return true;
                }

                // 看reach是否在map中
                Set<Integer> set = map.get(reach);
                if (set == null) {
                    continue;
                }

                // 如果在的话,向set中添加可以跳的步数
                if (step > 0) {
                    set.add(step - 1);
                }
                set.add(step);
                if (step < stones.length) {
                    set.add(step + 1);
                }
            }
        }
        return false;
    }
}
