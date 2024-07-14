# Construct String from Binary Tree

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
- Space Complexity: O(N)
  - N as nodes

```java
class Solution{
    StringBuilder sb;
    public String tree2str(TreeNode root) {
        sb = new StringBuilder();
        dfs(root);
        return sb.toString();
    }
    public void dfs(TreeNode node){
        if(node == null){
            return;
        }
        sb.append(String.valueOf(node.val));
        if(node.left == null && node.right == null){
            return;
        }
        sb.append("(");
        dfs(node.left);
        sb.append(")");
        if(node.right != null){
            sb.append("(");
            dfs(node.right);
            sb.append(")");
        }
    }
}
```
