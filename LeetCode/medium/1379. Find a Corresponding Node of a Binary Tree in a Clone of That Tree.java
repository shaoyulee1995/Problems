/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    
    boolean found;
    TreeNode ans;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        found = false;
        preOrder(original, cloned, target);
        return ans;
    }
    public void preOrder(TreeNode original, TreeNode cloned, TreeNode target){
        if(original == null || found == true){
            return;
        }
        if(original == target){
            ans = cloned;
            found = true;
            return;
        }
        preOrder(original.left, cloned.left, target);
        preOrder(original.right, cloned.right, target);
    }
}