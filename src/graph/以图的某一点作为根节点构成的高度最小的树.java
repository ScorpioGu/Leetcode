package graph;

import java.util.*;

/**
 * @Desc https://leetcode.com/problems/minimum-height-trees/
 * Example 1 :
 *
 * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *
 *         0
 *         |
 *         1
 *        / \
 *       2   3
 *
 * Output: [1]
 * Example 2 :
 *
 * Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 *
 *      0  1  2
 *       \ | /
 *         3
 *         |
 *         4
 *         |
 *         5
 *
 * Output: [3, 4]
 * @Author gcc
 * @Date 18-12-19 下午10:27
 **/
public class 以图的某一点作为根节点构成的高度最小的树 {
    /**
     * 类似剥洋葱的方法，就是一层一层的褪去叶节点，最后剩下的一个或两个节点就是我们要求的最小高度树的根节点.
     * @param n 边的个数
     * @param edges 图的边,这是一个无向图
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        //存放图中的叶子节点,即它只有一个邻居的节点
        List<Integer> leaves = new ArrayList<>();
        //graph的第i个位置,存放节点i的所有邻居节点
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            List<Integer> newLeaves = new ArrayList<>();
            //对于叶子节点,它只有一个邻居,找到这个邻居,然后邻居把这个叶子删了
            for (Integer leaf : leaves) {
                //set的iterator().next()用来取出set中的元素
                int neig = graph.get(leaf).iterator().next();
                graph.get(neig).remove(leaf);
                if (graph.get(neig).size() == 1) {
                    newLeaves.add(neig);
                }
            }
            n -= leaves.size();
            leaves = newLeaves;
        }
        return leaves;
    }
}
