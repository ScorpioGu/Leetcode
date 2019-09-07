package array;

import java.util.HashMap;

/**
 * @Desc https://leetcode.com/problems/4sum-ii/
 * @Author gcc
 * @Date 19-6-12 下午7:38
 **/
public class _4sum {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        // key为元素和，value为出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                res += map.getOrDefault(-1 * (A[i] + B[j]), 0);
            }
        }

        return res;
    }
}
