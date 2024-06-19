# Binary Tree Paths

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
- Space Complexity: O(N)

```
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList();
        if(root == null){
            return null;
        }
        binaryTreePaths(root, list, "");
        return list;
    }
    private void binaryTreePaths(TreeNode node, List<String> list, String path){
        if(node.left == null && node.right == null){
            list.add(path + node.val);
            return;
        }
        if(node.left != null){
            binaryTreePaths(node.left, list, path+node.val+"->");
        }
        if(node.right != null){
            binaryTreePaths(node.right, list, path+node.val+"->");
        }
    }
}
```
