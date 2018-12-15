package design;

import support.TreeNode;

import java.util.*;

/**
 * @Desc https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * Example:
 *
 * You may serialize the following tree:
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * as "[1,2,3,null,null,4,5]"
 *
 * 序列化成什么样的格式并不重要,只需要保证能够反序列化成功即可
 * Note:不允许使用成员变量保存状态,这个工具类应该是无状态的
 *
 * 重建一颗二叉树的一般要求前序序列+中序序列或者中序序列+后序序列
 * 这里因为序列化的过程中存储了null,所以一条序列即可完成重建
 * @Author gcc
 * @Date 18-12-15 上午10:51
 **/
public class 序列化与反序列化二叉树 {
    private final static String SPLITRER = ",";
    private final static String NULL = "x";
    // Encodes a tree to a single string.
    //先序遍历来做做看
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode cur, StringBuilder sb) {
        if (cur == null) {
            sb.append(NULL).append(SPLITRER);
        } else {
            sb.append(cur.val).append(SPLITRER);
            buildString(cur.left, sb);
            buildString(cur.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(SPLITRER)));
        return buildTree(q);
    }

    /**
     * 为什么要用队列而不使用String[]配合索引index?因为这是dfs的做法,左右子树的值在
     * 字符串中并不相邻,也就是说index的变化并不固定.而使用队列,每个新增一个节点节点中
     * 删除队头元素,无需管理新增的节点使用的是哪一个索引的值,保证新增节点的值一定是队头
     * 元素.
     * @param q
     * @return
     */
    private TreeNode buildTree(Queue<String> q) {
        String val = q.remove();
        if (NULL.equals(val)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(q);
            node.right = buildTree(q);
            return node;
        }
    }
}
