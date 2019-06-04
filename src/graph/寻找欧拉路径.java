package graph;

import java.util.*;

/**
 * @Desc https://leetcode.com/problems/reconstruct-itinerary/
 * Given a linklist of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 *
 * Note:
 *
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * Example 1:
 *
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * @Author gcc
 * @Date 19-1-4 上午10:18
 **/
public class 寻找欧拉路径 {
    LinkedList<String> list = new LinkedList<>();
    //存储每个顶点及其所有的边,因为要求字典序,所以用了一个最小堆优先级队列
    Map<String, PriorityQueue<String>> map = new HashMap<>();

    public List<String> findItinerary(String[][] tickets) {
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                PriorityQueue<String> q = new PriorityQueue<String>();
                map.put(ticket[0], q);
            }
            map.get(ticket[0]).offer(ticket[1]);
        }
        visit("JFK");
        return list;
    }

    /**
     * Hierholzer's algorithm
     * @param v
     */
    private void visit(String v) {
        PriorityQueue<String> q = map.get(v);
        while (q != null && !q.isEmpty()) {
            visit(q.poll());
        }
        list.addFirst(v);
    }
}

