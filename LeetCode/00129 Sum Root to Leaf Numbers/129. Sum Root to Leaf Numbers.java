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
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    public int sumNumbers(TreeNode root, int curVal) {
        if(root == null){
            return 0;
        }
        curVal = curVal * 10 + root.val;
        if(root.left == null && root.right == null){
            return curVal;
        } 
        return sumNumbers(root.left, curVal) + sumNumbers(root.right, curVal);
    }
}