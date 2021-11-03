/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
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
    int result = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root != null) {
            travelAllLeft(root);
        }
        return result;
    }

    private void travelAllLeft(TreeNode node) {
        if (node.left != null) {
            if (node.left.left == null && node.left.right == null) {
                result = result + node.left.val;
            } else {
                travelAllLeft(node.left);
            }
        }
        if (node.right != null) {
            travelAllLeft(node.right);
        }
        return;
    }
}
// @lc code=end

