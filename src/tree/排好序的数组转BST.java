/**
 * Author:   gucheng
 * Date:     18-4-27 上午11:52
 * Description: Convert a descending array to a height-balanced BST
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 */
package tree;

import support.TreeNode;

public class 排好序的数组转BST {

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
