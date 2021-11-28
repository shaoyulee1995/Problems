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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        
        for(int i = 1; i < preorder.length; i++){
            setNode(root, preorder[i]);            
        }
        // System.gc();
        return root;
    }
    
    private void setNode(TreeNode node, int val){
        if(node.val < val){
            if(node.right == null){
                node.right = new TreeNode(val);
            }else{
                setNode(node.right, val);
            }
        }else{
            if(node.left == null){
                node.left = new TreeNode(val);
            }else{
                setNode(node.left, val);
            }
        }
    }
}