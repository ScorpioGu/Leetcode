/**
 * Author:   gucheng
 * Date:     18-5-1 下午8:37
 * Description: https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 */
package tree;

public class SumRoottoLeafNumbers {
/*    public int sumNumbers(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        List<Integer> cur = new ArrayList<Integer>();
        res.add(0);
        cur.add(0);
        helper(root, cur, res);
        return res.get(0);
    }

    private void helper(TreeNode root, List<Integer> cur, List<Integer> res) {
        if (root == null) {
            return;
        }
        cur.set(0, cur.get(0) * 10 + root.val);
        if (root.right == null && root.left == null) {
            res.set(0, res.get(0) + cur.get(0));
            cur.set(0, (cur.get(0) - root.val)/10);
            return;
        } else {
            helper(root.left, cur, res);
            helper(root.right, cur, res);
        }
        cur.set(0, (cur.get(0) - root.val)/10);
    }*/

    //这种递归，不需要回溯，往下传值就可以，与PathSUmII对比一下，同样是DFS，PathSumII往下递归，方法参数中是对象，在递归过程中，方法内对其
    //修改会同样作用到方法外，所以需要在递归时，需要保护现场。但是这个题，传递的就是一个基本类型值，需要的结果是通过方法的返回值累加获得的获得的、
    //在递归过程中，在左子树中修改这个sum后，右子书的sum不会跟着改变。上面被我注释掉的代码是多此一举的。
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    //遍历到这个节点的时候，上面的和是sum
    private int helper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 10 * sum + root.val;
        }
        return helper(root.left, 10 * sum + root.val) + helper(root.right, 10 * sum + root.val);
    }
}
