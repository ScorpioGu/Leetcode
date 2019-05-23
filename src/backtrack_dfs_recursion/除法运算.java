package backtrack_dfs_recursion;

import java.util.*;

/**
 * @Desc https://leetcode.com/problems/evaluate-division/Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
 *
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 * @Author gcc
 * @Date 19-1-14 下午8:43
 **/
public class 除法运算 {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        // neighbours保存顶点以及它的邻节点
        Map<String, List<String>> neighbours = new HashMap<>();
        // weights保存节点到邻节点相除的值,因为list是有序的,neighbours中第i个位置的邻节点对应着weights中第i个位置的相除的值
        Map<String, List<Double>> weights = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] cur = equations[i];
            if (!neighbours.containsKey(cur[0])) {
                neighbours.put(cur[0], new ArrayList<>());
                weights.put(cur[0], new ArrayList<>());
            }
            if (!neighbours.containsKey(cur[1])) {
                neighbours.put(cur[1], new ArrayList<>());
                weights.put(cur[1], new ArrayList<>());
            }

            neighbours.get(cur[0]).add(cur[1]);
            weights.get(cur[0]).add(values[i]);
            neighbours.get(cur[1]).add(cur[0]);
            weights.get(cur[1]).add(1.0 / values[i]);
        }

        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            res[i] = dfs(query[0], query[1], neighbours, weights, new HashSet<>(), 1.0);
            if (res[i] == 0.0) {
                res[i] = -1.0;
            }
        }
        return res;
    }

    /**
     *
     * @param start 起点
     * @param end   终点
     * @param neighbours
     * @param weights
     * @param set   当前已经走过的路径
     * @param val   当前的值
     * @return
     */
    private double dfs(String start, String end, Map<String, List<String>> neighbours, Map<String, List<Double>> weights, HashSet<String> set, double val) {
        if (set.contains(start)) {
            return 0.0;
        }
        if (!neighbours.containsKey(start)) {
            return 0.0;
        }
        if (start.equals(end)) {
            return val;
        }
        set.add(start);

        List<String> ns = neighbours.get(start);
        List<Double> vals = weights.get(start);
        double res = 0.0;
        for (int i = 0; i < ns.size(); i++) {
            res = dfs(ns.get(i), end, neighbours, weights, set, val * vals.get(i));
            //只要找到了一条路径即可返回
            if (res != 0) {
                break;
            }
        }
        set.remove(start);
        return res;
    }
}
