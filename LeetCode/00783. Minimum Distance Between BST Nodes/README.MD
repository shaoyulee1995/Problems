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
# Traversal
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as nodes in tree
```
class Solution {
    TreeNode prev;
    int res;
    public int minDiffInBST(TreeNode root) {
        prev = null;
        res = Integer.MAX_VALUE;
        traverse(root);
        return res;
    }
    public void traverse(TreeNode node){
        if(node == null){
            return;
        }
        traverse(node.left);
        if(prev != null){
            res = Math.min(res, node.val - prev.val);
        }
        prev = node;
        traverse(node.right);
    }
}
```