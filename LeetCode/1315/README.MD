# Sum of Nodes with Even-Valued Grandparent

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

# Recurseion

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null){
            return 0;
        }
        return helper(root, 1, 1);
    }

    public int sumEvenGrandparent(TreeNode root, int p, int gp){
        if(root == null){
            return 0;
        }
        return sumEvenGrandparent(root.left, root.val, p) +
                sumEvenGrandparent(root.right, root.val, p) +
                (gp%2 == 0?  root.val: 0);
    }
}
```
