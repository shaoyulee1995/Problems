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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if(root==null){
            return list;
        }
        postOrder(list, root);
        return list;
    }
    private void postOrder(List<Integer> list, TreeNode node){
        if(node == null){
            return;
        }
        postOrder(list, node.left);
        postOrder(list, node.right);
        list.add(node.val);
    }
}