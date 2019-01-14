package sort;

import java.util.PriorityQueue;

/**
 * @Desc https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Example:
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 *
 * 这一题的做法和 两有序数组中选出k对使得和最小那题 相同
 * 两道题本质上是相同的
 * @Author gcc
 * @Date 19-1-12 下午10:01
 **/
public class 有序二维数组中寻找第k小的元素 {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }
        //因为要存一下元素的坐标信息,所以需要一个封装类
        PriorityQueue<Tuple> q = new PriorityQueue<>();
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            q.offer(new Tuple(0, i, matrix[0][i]));
        }
        Tuple out = null;
        while (k-- != 0) {
            out = q.poll();
            int i = out.i + 1, j = out.j;
            if (i < len) {
                q.offer(new Tuple(out.i + 1, out.j, matrix[i][j]));
            }
        }
        return out.val;
    }

    class Tuple implements Comparable<Tuple>{
        int i;
        int j;
        int val;

        Tuple(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.val - o.val;
        }
    }
}
