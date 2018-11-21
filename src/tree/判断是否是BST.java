/**
 * Author:   gucheng
 * Date:     18-4-30 下午3:03
 * Description: https://leetcode.com/problems/validate-binary-search-tree/description/
 * 第一种：
 * 利用中序遍历，数值大小从小到达排列的性质，一旦出现当前节点值比前驱节点小，则返回false。需要保存一个前驱节点的变量，注意java中只有值传递
 * 如果传一个值进去，方法内修改之后是没有效果的。对于递归这样的算法，我们希望方法栈每出栈对于前驱节点的修改，能够对下一层方法有效。所以可以传递
 * 一个容器，容器中持有一个前驱节点的值（java方法参数对于对象是浅拷贝），或者新建一个类，类里面有一个int类型的成员变量，方法内传递这个类的对象也是可以的。
 * 然后中序遍历要找到最左边的节点，这个过程中是没有前驱节点的，所以刚开始容器中放了null。找到最左下角的节点之后开始回溯，将前驱节点设为自己之后,root变为父节点
 * 比较root和前驱的值，若有问题，直接返回false,否则父节点还要和右孩子比，父节点再把自己设为前驱，root变成了右孩子，再比较。最终返回的是两个比较结果相与。
 * 因为一旦有一次比较出问题了，直接返回了false，所以不用担心两个false返回true的情况。
 * 第二种：
 * BST的左子树的所有值一定比其值小，右子树一定比其值大。所以，记录每个子树的上下界，当向左走时，将父节点的值作为上界，下界不变，向右走时，父节点的值作为下界，上界不变。
 * 对于根节点，上下界为无穷大和无穷小。
 * 第三种：
 * 非递归方式，中序遍历，和第一种方式思想类似，但是写法不同，使用栈作为辅助，保证每个节点出栈都是按照中序的顺序
 */
package tree;

import support.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 *  它或者是一棵空树，或者是具有下列性质的二叉树： 若它的左子树不空，
 *  则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，
 *  则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也
 *  分别为二叉排序树。
 */


//中序遍历，递归，保存前驱节点。因为中序遍历BST，是升序的，每次比较当前节点的值与前驱节点的值。
public class 判断是否是BST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root!= null) {
                stack.push(root);
                root = root.left;
            }
            //节点出栈的顺序和中序遍历顺序一致，
            root = stack.pop();
            if (pre != null && pre.val >= root.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }

    /**
     * 记录每个子树的上下界，当向左走时，将父节点的值作为上界，下界不变，向右走时，父节点的值作为下界，上界不变。
     * 对于根节点，上下界为无穷大和无穷小。
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min) {
            return false;
        }
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    public boolean isValidBST3(TreeNode root) {
        //pre保存前驱节点的值，必须要将这个值放在一个对象中传入方法参数，如果直接用int保存，该值在方法中被修改后，方法执行之后没有效果
        //因为java参数传递是值拷贝。
        List<Integer> pre = new ArrayList<Integer>();
        pre.add(null);
        return helper(root, pre);
    }

    //该方法出方法栈的顺序也按照中序的顺序，root参数代表特定一个节点代表的方法
    private boolean helper(TreeNode root, List<Integer> pre) {
        //遍历到叶子节点了，返回true
        if (root == null) {
            return true;
        }
        //left表示pre的左子树是否为BST
        boolean left = helper(root.left, pre);
        //此时root停在中间，pre停在左边，如果中间比左边小，直接false就不比了
        if (pre.get(0) != null && root.val < pre.get(0)) {
            return false;
        }
        //否则，把pre设为中间，root转到右节点，判断右子树。若左右都为true才是真的true
        pre.set(0, root.val);
        return left && helper(root.right, pre);
    }

}
