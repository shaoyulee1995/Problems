class Solution {
    public TreeNode convertBST(TreeNode root) {
        revInOrderUtil(root, new TreeNode());
        return root;
    }
    
    private void revInOrderUtil(TreeNode node, TreeNode prev) {
        if(node == null) return;
        revInOrderUtil(node.right, prev);
        node.val += prev.val;
        prev.val = node.val;
        revInOrderUtil(node.left, prev);
    }
}