/*
 * @lc app=leetcode.cn id=559 lang=java
 *
 * [559] N 叉树的最大深度
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        while (!root.children.isEmpty()) {
            return maxChildDepth(root.children) + 1;
        }
        return 1;
    }

    private int maxChildDepth(List<Node> nodes) {
        int result = 0;
        for (Node node : nodes) {
            int childDepth = maxDepth(node);
            if (childDepth > result) {
                result = childDepth;
            }
        }
        return result;
    }
}
// @lc code=end

