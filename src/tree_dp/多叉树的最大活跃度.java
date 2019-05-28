package tree_dp;

import java.util.List;

/**
 * @Desc 用Node节点描述一棵多叉树，每个节点的值代表它的活跃度。如果选择了某个节点，则其下级节点都不能选。
 * 求一种选择方式，使整个的活跃度最大
 * @Author gcc
 * @Date 19-5-28 下午1:53
 **/
public class 多叉树的最大活跃度 {
    private class Node {
        int val;
        List<Node> sub;
    }


    private class ReturnData {
        int maxInclude;
        int maxNotInclude;

        public ReturnData(int maxInclude, int maxNotInclude) {
            this.maxInclude = maxInclude;
            this.maxNotInclude = maxNotInclude;
        }
    }


    public int getMax(Node root) {
        ReturnData res = process(root);
        return Math.max(res.maxInclude, res.maxNotInclude);
    }

    private ReturnData process(Node cur) {
        if (cur == null) {
            return new ReturnData(0, 0);
        }

        List<Node> sub = cur.sub;
        int maxInclude = cur.val;
        int maxNotInclude = 0;
        for (Node node : sub) {
            ReturnData subData = process(node);
            // 如果当前节点选择了自己，那么子节点们都不能选自己了
            maxInclude += subData.maxNotInclude;

            // 如果当前节点没有选择自己，那么子节点们可以选择自己与可以不选
            maxNotInclude += Math.max(subData.maxInclude, subData.maxNotInclude);
        }

        return new ReturnData(maxInclude, maxNotInclude);
    }

}
