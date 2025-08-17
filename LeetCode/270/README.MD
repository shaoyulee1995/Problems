# Closest Binary Search Tree Value

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
  - N as nodes
  
```java
class Solution {
    TreeNode res;
    double minValue;
    public int closestValue(TreeNode root, double target) {
        res = root;
        minValue = Math.abs(root.val - target);
        dfs(root, target);
        return res.val;
    }

    private void dfs(TreeNode node, double target){
        if(node == null){
            return;
        }
        dfs(node.left, target);
        if(Math.abs(node.val - target) < minValue){
            res = node;
            minValue = Math.abs(node.val - target);
        }else if(Math.abs(node.val - target) == minValue && res.val > node.val){
            res = node;
        }
        dfs(node.right, target);
    }
}
```