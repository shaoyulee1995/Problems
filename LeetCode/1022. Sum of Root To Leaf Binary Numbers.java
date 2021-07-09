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
    public int sumRootToLeaf(TreeNode root) {
        return calculate(root, 0);
    }
    private int calculate(TreeNode root, int val){
        if(root==null){
            return 0;
        }
        val = val*2 + root.val;
        if(root.left == root.right){
            return val;
        }
        return calculate(root.left, val) + calculate(root.right, val);
    }
}