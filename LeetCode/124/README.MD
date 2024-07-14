# Binary Tree Maximum Path Sum

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

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as nodes

```java
class Solution {
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }

    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = Math.max(0, dfs(node.left)),
            right = Math.max(0, dfs(node.right)),
            sum = left + right + node.val;
        max = Math.max(max, sum);
        return node.val + Math.max(left, right);
    }
}
```
