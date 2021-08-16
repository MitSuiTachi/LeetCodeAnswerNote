/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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
    private List<String> result = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return null;
        }
        generatePathAndInsert(root, "");
        return result;
    }

    private void generatePathAndInsert(TreeNode node, String path) {
        String s = new String(path);
        if (node != null) {
            s = s + String.valueOf(node.val);
            if (node.right == null && node.left == null) {
                result.add(s);
            }
            if (node.right != null) {
                generatePathAndInsert(node.right, s + "->");
            }
            if (node.left != null) {
                generatePathAndInsert(node.left, s + "->");
            }
        }
    }
}

// @lc code=end

