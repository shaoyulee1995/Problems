# Search in a Binary Search Tree

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

- Time Complexity: O(logN)
- Space Complexity: O(1)

```java
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        return (root.val < val)? searchBST(root.right, val): searchBST(root.left, val);
    }
}
```

- Time Complexity: O(logN)
- Space Complexity: O(1)

```java
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null && root.val != val){
            root = ((root.val<val)?root.right: root.left);
        }
        return root;
    }
}
```
