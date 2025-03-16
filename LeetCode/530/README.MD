# Minimum Absolute Difference in BST

```
Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
```

# Tree InOrder Traversal

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as nodes in the tree

```java
class Solution {
    TreeNode prev;
    Integer res;
    public int getMinimumDifference(TreeNode root) {
        prev = null;
        res = Integer.MAX_VALUE;
        dfs(root);
        return res;
    }
    public void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        if(prev != null){
            res = Math.min(res, Math.abs(node.val - prev.val));
        }
        prev = node;
        dfs(node.right);
    }
}
```
