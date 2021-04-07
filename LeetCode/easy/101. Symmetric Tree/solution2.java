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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode son1 = queue.poll(),
                     son2 = queue.poll();
            
            if(son1 == null && son2 == null){
                continue;
            }
            if(son1 == null || son2 == null || son1.val != son2.val){
                return false;
            }
            
            queue.add(son1.left);
            queue.add(son2.right);
            queue.add(son1.right);
            queue.add(son2.left);
        }
        return true;
    }
}