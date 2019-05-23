package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc https://leetcode.com/problems/clone-graph/
 * @Author gcc
 * @Date 19-3-31 上午10:54
 **/
public class 无向图的深拷贝 {
    /**
     * key为旧节点，value为新节点。图中可能会出现两次遍历到同一节点的情况，如果第二次遍历到了从map中能够查找处便不再需要创建新的节点
     */
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node,newNode);
        List<Node> newNeigh = newNode.neighbors;
        for(Node nei: node.neighbors) {
            Node k = cloneGraph(nei);
            newNeigh.add(k);
        }
        return newNode;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };
}


