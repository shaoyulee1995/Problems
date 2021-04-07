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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(p);
        queue.add(q);
        while(!queue.isEmpty()){
            TreeNode pSon = queue.poll(),
                     qSon = queue.poll();
            
            if(pSon==null && qSon == null){
                continue;
            }
            if(pSon == null || qSon == null){
                return false;
            }
            if(pSon.val != qSon.val){
                return false;
            }
            
            queue.add(pSon.left);
            queue.add(qSon.left);
            queue.add(pSon.right);
            queue.add(qSon.right);
        }
        return true;
    }
}