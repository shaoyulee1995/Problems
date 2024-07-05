# Univalued Binary Tree

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

- Time Complexity: O(N)
- Space Complexity: O(1)

```
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return dfs(root, root.val);
    }
    public boolean dfs(TreeNode node, int val){
        if(node == null){
            return true;
        }
        if(node.val != val){
            return false;
        }
        return dfs(node.left, val) && dfs(node.right, val);
    }
}
```
