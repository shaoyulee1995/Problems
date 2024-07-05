# Second Minimum Node In a Binary Tree

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

```
class Solution {
    Integer min1 = null,
            min2 = null;
    public int findSecondMinimumValue(TreeNode root) {
        min1 = root.val;
        dfs(root);
        return min2 != null? min2: -1;
    }

    public void dfs(TreeNode node){
        if(node == null){
            return;
        }
        if(min1 < node.val && (min2 == null || min2 > node.val)){
            min2 = node.val;
        }else if(min1 == node.val){
            dfs(node.left);
            dfs(node.right);
        }
    }
}
```
