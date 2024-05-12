# Two Sum IV - Input is a BST
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
# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as nodes of tree
```
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet();
        return findTarget(root, k, set);
    }
    public boolean findTarget(TreeNode root, int k, HashSet<Integer> set) {
        if(root == null){
            return false;
        }
        if(set.contains(k-root.val)){
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k, set) || findTarget(root.right, k, set);
    }
}
```