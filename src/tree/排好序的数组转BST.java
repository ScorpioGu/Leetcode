/**
 * Author:   gucheng
 * Date:     18-4-27 上午11:52
 * Description: Convert a descending array to a height-balanced BST
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 */
package tree;

import support.TreeNode;

public class 排好序的数组转BST {
/*    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        if (length == 1)
            return new TreeNode(nums[0]);
        if (length == 0)
            return null;
        TreeNode root = new TreeNode(nums[length / 2]);
        int[] leftNums = Arrays.copyOfRange(nums, 0, length / 2 - 1);
        int[] rightNums = null;
        //注意长度为2时，是没有右子树的
        if (length != 2) {
            rightNums = Arrays.copyOfRange(nums, length / 2 + 1, length - 1);
        }
        root.left = sortedArrayToBST(leftNums);
        root.right = sortedArrayToBST(rightNums);
        return root;
    }*/

    //不需要从大数组中切割出小数组，只要传递原数组过去并记录要处理部分的开始与结束的坐标即可。
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int l, int r) {
        if (r<l) {
            return null;
        }
        int m = (l + r) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = helper(nums, l, m - 1);
        root.right = helper(nums, m + 1, r);
        return root;
    }

}
