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
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as nodes
```
class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }
    public boolean dfs(TreeNode node, Integer min, Integer max){
        if(node == null){
            return true; 
        }
        if(min != null && min >= node.val){
            return false;
        }
        if(max != null && max <= node.val){
            return false;
        }
        return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
    }
}
```
# DFS
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as nodes
```
class Solution {
    long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        if(prev >= root.val){
            return false;
        }
        prev = root.val;
        return isValidBST(root.right);
    }
}
```
# BFS
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as nodes
```
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if(prev != null && prev.val >= node.val){
                return false;
            }
            prev = node;
            root = node.right;
        }
        return true;
    }
}
```