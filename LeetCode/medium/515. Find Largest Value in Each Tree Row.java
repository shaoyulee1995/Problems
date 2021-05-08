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
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList();
        }
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        List<Integer> list = new ArrayList();
        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                TreeNode child = q.poll();
                if(child.left != null){
                    q.add(child.left);
                }
                if(child.right != null){
                    q.add(child.right);
                }
                max = Math.max(child.val, max);
            }
            list.add(max);
        }
        return list;
    }
}