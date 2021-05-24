/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null && targetSum == 0) {
//            return true;
//        }
//        if(root == null) {
//            return false;
//        } else {
//            return hasPathSum(root.right, targetSum - root.val) || hasPathSum(root.left, targetSum - root.val);
//        }
        if (root == null) {
            return false;
        }
        if (root.right == null && root.left == null && targetSum == root.val) {
            if(targetSum == root.val) {
                return true;
            } else {
                return false;
            }
        } else {
            return hasPathSum(root.right, targetSum - root.val) || hasPathSum(root.left, targetSum - root.val);
        }
    }
}
// @lc code=end

