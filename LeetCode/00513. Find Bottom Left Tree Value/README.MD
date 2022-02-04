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
    int height = 0, ans = 0;
    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 1);
        return ans;
    }
    public void findBottomLeftValue(TreeNode root, int depth){
        if(height < depth){
            ans = root.val;
            height = depth;
        }
        if(root.left != null){
            findBottomLeftValue(root.left, depth+1);
        }
        if(root.right != null){
            findBottomLeftValue(root.right, depth+1);
        }
    }
}
```