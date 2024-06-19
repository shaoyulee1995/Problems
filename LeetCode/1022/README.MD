# Sum of Root To Leaf Binary Numbers

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

# Recursion

- Time Complexity: O(N)
- Space Complexity: O(1)

```
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, 0);
    }
    public int sumRootToLeaf(TreeNode root, int val) {
        if(root == null){
            return 0;
        }
        val = (val << 1) + root.val;
        if(root.left == null && root.right == null){
            return val;
        }
        return sumRootToLeaf(root.left, val) + sumRootToLeaf(root.right, val);
    }
}
```
