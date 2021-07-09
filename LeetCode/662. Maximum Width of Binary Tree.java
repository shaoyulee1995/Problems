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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        root.val = 1;
        q.add(root);
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int diff = 0, size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode current = q.poll();
                if(i == 0){
                    diff = current.val;
                }
                if(i == size - 1){
                    diff = current.val - diff + 1;
                }
                if(current.left!=null){
                    current.left.val = current.val * 2 - 1;
                    q.offer(current.left);
                }
                if(current.right!=null){
                    current.right.val = current.val * 2;
                    q.offer(current.right);
                }
            }
            max = Math.max(max, diff);
        }
        return max;
    }
}