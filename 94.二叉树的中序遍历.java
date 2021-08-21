class Solution {

    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }
        inorderTraversalAndRecord(root);
        return result;
    }
    // 二叉树的中序遍历是指优先（中序）遍历访问二叉树的左子树 当左子树为空时 访问当前节点 并（中序）遍历访问右子树
    // 从描述可以看出可以使用递归进行 因为无论对左子树还是右子树 也都是同样进行中序遍历
    private void inorderTraversalAndRecord(TreeNode node) {
        if(node.left != null) {
            // 优先递归访问左子树
            inorderTraversalAndRecord(node.left);
        }
        // 记录当前节点
        result.add(node.val);
        if(node.right != null) {
            // 递归访问右子树
            inorderTraversalAndRecord(node.right);
        }
    }
}