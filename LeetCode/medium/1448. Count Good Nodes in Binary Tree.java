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
    //the root itself is the "max" (temporatory)
    public int goodNodes(TreeNode root) {
        return preOrder(root, root.val);
    }
    public int preOrder(TreeNode node, int val){
        if(node == null){
            return 0;
        }
        int max = Math.max(node.val, val);
        
        return (node.val >= val? 1: 0) + 
            preOrder(node.left, max) + 
            preOrder(node.right, max); //update the max along the path
        
    }
}