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
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null){
            return 0;
        }
        return helper(root, 1, 1);
    }
    
    public int helper(TreeNode root, int p, int gp){
        if(root == null){
            return 0;
        }
        return helper(root.left, root.val, p) + helper(root.right, root.val, p) + 
            (gp%2 == 0?  root.val: 0);
    }
}