/*
 * @lc app=leetcode.cn id=1609 lang=java
 *
 * [1609] 奇偶树
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
    private Queue<TreeNode> queue = new LinkedList<>();
    private int currentDepth = 0;

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        queue.offer(root);
        return LevelOrderAndJudge();
    }

    // 偶数层为奇数 严格递增 奇数层为偶数 严格递减
    private boolean LevelOrderAndJudge() {
        int currentQueueSize = queue.size();
        if (currentQueueSize == 0) {
            return true;
        }
        boolean currentLevelFit;
        if (currentDepth % 2 == 0) {
            currentLevelFit = JudgeEvenLevel(currentQueueSize);
        } else {
            currentLevelFit = JudgeOddLevel(currentQueueSize);
        }
        if (currentLevelFit) {
            currentDepth++;
            return LevelOrderAndJudge();
        }
        return false;
    }

    // 奇数层为偶数 严格递减
    private boolean JudgeOddLevel(int size) {
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            if (node.val < temp && node.val % 2 == 0) {
                temp = node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    // 偶数层为奇数 严格递增
    private boolean JudgeEvenLevel(int size) {
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            if (node.val > temp && node.val % 2 != 0) {
                temp = node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

