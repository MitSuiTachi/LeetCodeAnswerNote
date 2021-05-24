/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private Queue<TreeNode> q1 = new LinkedList<>();
    private Queue<TreeNode> q2 = new LinkedList<>();
    private int result = 0;

    public int minDepth(TreeNode root) {
        TreeNode tempNode = null;
        
        if (root != null) {
            q1.offer(root);
            result = result + 1;
        } else {
            return result;
        }

        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    tempNode = q1.poll();
                    if (tempNode.left == null && tempNode.right == null) {
                        return result;
                    } else {
                        if (tempNode.left != null) {
                            q2.offer(tempNode.left);
                        }
                        if (tempNode.right != null) {
                            q2.offer(tempNode.right);
                        }
                    }
                }
                result++;
            } else {
                while (!q2.isEmpty()) {
                    tempNode = q2.poll();
                    if (tempNode.left == null && tempNode.right == null) {
                        return result;
                    } else {
                        if (tempNode.left != null) {
                            q1.offer(tempNode.left);
                        }
                        if (tempNode.right != null) {
                            q1.offer(tempNode.right);
                        }
                    }
                }
                result++;
            }
        }
        return result;
    }
}
// @lc code=end

