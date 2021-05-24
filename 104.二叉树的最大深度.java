/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
    public int maxDepth(TreeNode root) {
        if (root != null) {
            return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
//            return 1 + (maxDepth(root.left) > maxDepth(root.right) ? maxDepth(root.left) : maxDepth(root.right));
        }
        return 0;
//        if(root == null) {
//            return 0;
//        }
//        if(root.right == null && root.left == null) {
//            return 1;
//        }else {
//            return 1 + (maxDepth(root.left) > maxDepth(root.right) ? maxDepth(root.left) : maxDepth(root.right));
//        }
    }
}
// @lc code=end

