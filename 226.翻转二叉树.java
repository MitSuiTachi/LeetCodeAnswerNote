/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        reverseTree(root);
        return root;
    }

    private void reverseTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        
        reverseTree(root.left);
        reverseTree(root.right);
        return;
    }
}
// @lc code=end

