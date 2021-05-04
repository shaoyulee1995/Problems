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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList(),
                      list2 = new ArrayList();
        inOrder(root1, list1);
        inOrder(root2, list2);
        
        if(list1.size() != list2.size()){
            return false;
        }
        
        for(int i = 0; i < list1.size(); i++){
            if(list1.get(i) != list2.get(i)){
                return false;
            }
        }
        return true;
    }
    
    private void inOrder(TreeNode node, List<Integer> l){
        if(node == null){
            return;
        }
        if(node.left != null){
            inOrder(node.left, l);
        }
        if(node.right != null){
            inOrder(node.right, l);
        }
        if(node.left == node.right){
            l.add(node.val);
        }
    }
}