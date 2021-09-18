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
# DFS
* Time Complexity: O(Max(M, N))
* Space Complexity: O(Max(M, N))

```
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null){
            return root2;
        }       
        if(root2 == null){
            return root1;
        }
        TreeNode mergeTree = new TreeNode(root1.val + root2.val);
        mergeTree.left = mergeTrees(root1.left, root2.left);
        mergeTree.right = mergeTrees(root1.right, root2.right);
        return mergeTree;
    }
}
```