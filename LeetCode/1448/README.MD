# Count Good Nodes in Binary Tree

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
  - N as nodes in tree

```java
class Solution {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }
    public int goodNodes(TreeNode root, int val){
        if(root == null){
            return 0;
        }
        int max = Math.max(root.val, val);
        return (root.val >= val? 1: 0) + goodNodes(root.left, max) + goodNodes(root.right, max);
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as nodes in tree
  
```java
class Solution {
    int res;

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        res = 0;
        dfs(root, root.val);
        return res;
    }

    private void dfs(TreeNode node, int val) {
        if (node == null) {
            return;
        }
        if (node.val >= val) {
            res++;
        }
        dfs(node.left, Math.max(node.val, val));
        dfs(node.right, Math.max(node.val, val));
    }
}
```