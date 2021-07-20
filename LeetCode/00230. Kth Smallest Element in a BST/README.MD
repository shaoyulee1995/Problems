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
* Time Complexity: O(N)
* Space Complexity: O(1)	

```
class Solution {
    int res = 0, rank = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }
    public void traverse(TreeNode node, int k){
        if(node == null){
            return;
        }
        traverse(node.left, k);
        rank++;
        if(rank == k){
            res = node.val;
            return;
        }
        traverse(node.right, k);
    } 
}
```