# Flatten Binary Tree to Linked List

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

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)

```java
class Solution {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left,
                 right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while(p.right != null){
            p = p.right;
        }
        p.right = right;
    }
}
```
