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
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if(n%2 == 0){
            return ans;
        }
        if(n == 1){
            ans.add(new TreeNode(0));
            return ans;
        }
        
        for(int leftN = 1; leftN <= n - 1; leftN +=2){
            List<TreeNode> leftTree = allPossibleFBT(leftN),
                     rightTree = allPossibleFBT(n-1-leftN);
            for(TreeNode left: leftTree){
                for(TreeNode right: rightTree){
                    TreeNode node = new TreeNode(0);
                    node.left = left;
                    node.right = right;
                    ans.add(node);
                }
            }
        }
        return ans;
    }
}