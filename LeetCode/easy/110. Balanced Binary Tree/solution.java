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
    boolean balance = true;
    
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return balance;
        }
        isBalancedHelper(root);
        return balance;
    }
    public int isBalancedHelper(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = isBalancedHelper(root.left),
            right = isBalancedHelper(root.right);
        if(Math.abs(left - right) > 1){
            balance = false;
        }
        return 1 + Math.max(left, right);
    }
}