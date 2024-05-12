# Subtree of Another Tree
```
Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
```
# DFS
* Time Complexity: O(N)
* Space Complexity: O(1)
    * N as nodes in tree
```
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        return dfs(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean dfs(TreeNode node, TreeNode subNode){
        if(node == null && subNode == null){
            return true;
        }
        if(node == null || subNode == null){
            return false;
        }
        if(node.val != subNode.val){
            return false;
        }
        return dfs(node.left, subNode.left) && dfs(node.right, subNode.right);
    }
}
```