# Distribute Coins in Binary Tree

```java
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

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as nodes in tree

```java
class Solution {
    int res;
    public int distributeCoins(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = dfs(node.left),
            right = dfs(node.right);
        res += Math.abs(left) + Math.abs(right);
        return (node.val-1) + left + right;
    }
}
```