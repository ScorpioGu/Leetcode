package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Desc 给一个数组，比如[10,20,30],表示一个长度为60的金条，对其切割，最终分成10,20,30.
 * 对长度为x的金条切任意一刀，花费x元。问怎么样切割花费最少。
 *
 * 哈弗曼编码问题的变形
 * @Author gcc
 * @Date 19-5-23 下午2:00
 **/
public class 切金条问题 {
    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }

    public static class MinheapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2; // < 0  o1 < o2  负数
        }

    }

    public static class MaxheapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1; // <   o2 < o1
        }

    }
}
