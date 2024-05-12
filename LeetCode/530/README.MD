# Minimum Absolute Difference in BST
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
# Tree InOrder Traversal
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as nodes in the tree
```
class Solution {
    Integer prev = null;
    int res = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return res;
    }
    public void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        if(prev != null){
            res = Math.min(res, node.val - prev);
        }
        prev = node.val;
        inOrder(node.right);
    }
}
```