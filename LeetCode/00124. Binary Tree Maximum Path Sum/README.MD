```
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
```
# DFS
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftVal = Math.max(dfs(root.left), 0);
        int rightVal = Math.max(dfs(root.right), 0);
        
        int val = leftVal + rightVal + root.val;
        max = Math.max(val, max);
        
        return root.val + Math.max(leftVal, rightVal);
    }
}
```