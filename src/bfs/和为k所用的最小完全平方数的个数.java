package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Desc https://leetcode.com/problems/perfect-squares/
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 * @Author gcc
 * @Date 18-12-4 下午3:56
 **/
public class 和为k所用的最小完全平方数的个数 {

    /**
     * 比较容易想到的是BFS,但是这样做太慢了
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int level = 0;
        int maxSqr = (int)Math.ceil(Math.sqrt(n));
        int[] sqrs = new int[maxSqr];
        for (int i = 1; i <= maxSqr ; i++) {
            sqrs[i - 1] = i*i;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (true) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 0; j < sqrs.length; j++) {
                    if (cur + sqrs[j] == n) {
                        return level;
                    } else if (cur + sqrs[j] < n) {
                        queue.offer(cur + sqrs[j]);
                    } else {
                        break;
                    }
                }
            }
        }
    }

    /**
     * 动态规划,但是仍然有超时的问题
     * @param n
     * @return
     */
    public int numSquares2(int n) {
        int[] res = new int[n + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j*j <= i ; j++) {
                res[i] = Math.min(res[i], res[i - j * j] + 1);
            }
            System.out.println(res[i]);
        }
        return res[n];
    }

    public static void main(String[] args) {
        System.out.println(new 和为k所用的最小完全平方数的个数().numSquares2(12));
    }
}
