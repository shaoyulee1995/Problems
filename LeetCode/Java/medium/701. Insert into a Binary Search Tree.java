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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode insert = new TreeNode(val);
        if(root == null){
            root = insert;
            return root;
        }
        
        TreeNode cur = root;
        while(cur.val != val){
            if(cur.val > val){
                if(cur.left == null){
                    cur.left = insert;
                }
                cur = cur.left;
            }else{
                if(cur.right == null){
                    cur.right = insert;
                }
                cur = cur.right;
            }
        }
        System.gc();
        return root;
    }
}