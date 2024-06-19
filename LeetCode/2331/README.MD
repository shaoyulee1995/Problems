# Evaluate Boolean Binary Tree

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

# Recursion

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as nodes in tree

```
class Solution {
    public boolean evaluateTree(TreeNode root) {
        if(root.val == 0){
            return false;
        }
        if(root.val == 1){
            return true;
        }
        boolean left = evaluateTree(root.left),
                right = evaluateTree(root.right);
        return (root.val == 2)? left || right : left && right;
    }
}
```
