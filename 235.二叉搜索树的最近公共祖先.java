/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 二叉排序树的特征如下：
// 1.对于每一个节点而言，大于其左子节点，小于其右子节点
// 2.中序遍历这棵树，可得到一个有序（升序）序列
// 思路，对于二叉排序树中任意的一个节点，我们可以借助特征1找到一条从根节点到其的路径
// 那么对于任意的两个节点，我们可以找到两条从根节点到它们路径
// 具体这两个节点最近的公共父节点，一定是这两条路径上的“分叉点”
// 因此我们从根节点开始遍历，当第一次遇到两条路径走向分叉时，该位置的节点即为所得
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode currentNode = root;
        while (currentNode != null) {
            if (currentNode.val > p.val && currentNode.val > q.val) {
                currentNode = currentNode.left;
            } else if (currentNode.val < p.val && currentNode.val < q.val) {
                currentNode = currentNode.right;
            } else {
                return currentNode;
            }
        }
        return currentNode;
    }
}

// 此解法是我一开始的思路，对于二叉排序树上打的任意的两个节点，存在一个左右关系
// 其公共父节点，一定大于，“左边”节点所在树的最大节点leftMax，且小于“右边”节点所在树的最小节点rightMin
// [leftMax, rightMin]这个区间内的节点即为所求，当时在脑中想了一下，这个区间内应该是有且只有一个节点的
// 但是这个思路无法解决一个节点是另外一个节点父节点的情况，暂做记录吧
class Solution_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode leftNode;
        TreeNode rightNode;
        if (p.val < q.val) {
            leftNode = p;
            rightNode = q;
        } else {
            leftNode = q;
            rightNode = p;
        }
        int min = findLeftTreeMax(leftNode);
        int max = findRightTreeMin(rightNode);
        return findLowestCommonAncestor(root, min, max);
    }

    private TreeNode findLowestCommonAncestor(TreeNode root, int min, int max) {
        if (root.val >= min && root.val <= max) {
            return root;
        } else if (root.val > max) {
            return findLowestCommonAncestor(root.left, min, max);
        } else {
            return findLowestCommonAncestor(root.right, min, max);
        }
    }

    private int findLeftTreeMax(TreeNode node) {
        if (node.left == null) {
            return node.val;
        }
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }

    private int findRightTreeMin(TreeNode node) {
        if (node.right == null) {
            return node.val;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }
}

// @lc code=end

