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
//            递归进行，不为空节点则返回左右子树的较大值
//            此处调用Math.max()方法进行判断
            return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;

//            一开始使用如下三元运算符进行判断会导致Time Limited
//            return 1 + (maxDepth(root.left) > maxDepth(root.right) ? maxDepth(root.left) : maxDepth(root.right));

        }
        return 0;

//        Version 1.0        
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

