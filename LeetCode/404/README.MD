# Sum of Left Leaves

```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
```

# Solution 1

- Time Complexity: O(N)
- Space Complexity: O(1)

```
class Solution {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(isLeaf(root.left)){
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
    public boolean isLeaf(TreeNode node){
        if(node == null){
            return false;
        }
        return node.left == null && node.right == null;
    }
}
```

# Solution 2

- Time Complexity: O(N)
- Space Complexity: O(1)

```
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left != null && root.left.left == null && root.left.right == null){
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
```

# Solution 3

- Time Complexity: O(N)
- Space Complexity: O(1)

```
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }
    private int helper(TreeNode node, boolean isLeft){
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null && isLeft){
            return node.val;
        }
        return helper(node.left, true) + helper(node.right, false);
    }
}
```
