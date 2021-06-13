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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = goLeft(root),
            right = goRight(root);
        if(left==right){
            return (1 << left) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    private int goLeft(TreeNode node){
        int depth = 0;
        while(node != null){
            depth++;
            node = node.left;
        }
        return depth;
    }
    private int goRight(TreeNode node){
        int depth = 0;
        while(node != null){
            depth++;
            node = node.right;
        }
        return depth;
    }
}