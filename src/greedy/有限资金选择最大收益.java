package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Desc TODO
 * @Author gcc
 * @Date 19-5-23 下午2:20
 **/
public class 有限资金选择最大收益 {
    public static class Node {
        public int p;
        public int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static class MinCostComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }

    }

    public static class MaxProfitComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }

    }

    /**
     *
     * @param k 有限选k个
     * @param w 启动资金
     * @param profits 每个项目的利润（产出-投入）
     * @param costs 每个项目的投入
     * @return
     */
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] costs) {
        Node[] nodes = new Node[profits.length];
        for (int i = 0; i < profits.length; i++) {
            nodes[i] = new Node(profits[i], costs[i]);
        }

        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        for (int i = 0; i < nodes.length; i++) {
            minCostQ.add(nodes[i]);
        }
        for (int i = 0; i < k; i++) {
            // 把w能买的node全放在大根堆中
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= w) {
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return w;
            }
            // 如果大根堆不为空，从大根堆中拿出利润最大的
            w += maxProfitQ.poll().p;
        }
        return w;
    }
}
