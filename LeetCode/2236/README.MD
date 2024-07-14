# Root Equals Sum of Children

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

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as number of nodes

```java
class Solution {
    public boolean checkTree(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left != null && root.right != null){
            if(root.val - root.left.val - root.right.val != 0){
                return false;
            }
        }
        checkTree(root.left);
        checkTree(root.right);
        return true;
    }
}
```
