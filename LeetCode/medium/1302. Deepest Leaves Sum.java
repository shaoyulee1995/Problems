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
    public int deepestLeavesSum(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = 0, i = 0;
        while(!q.isEmpty()){
            
            for(i = q.size() - 1, res = 0; i >=0; i--){
               TreeNode node = q.poll();
                res += node.val;
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                } 
            }   
        }
        return res;
    }
}