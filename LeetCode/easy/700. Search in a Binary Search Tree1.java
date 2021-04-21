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
    TreeNode found = null;
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }    
        helper(root, val);
        
        if(found == null){
            return null;
        }
        return found;
        
    }
    
    private void helper(TreeNode node, int val){
        if(node == null){
            return;
        }
        
        if(node.val == val){
            found = node;
            return;
        }
        helper(node.left, val);
        helper(node.right, val);
    }
}