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
    int sum;
    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        dfs(root);
        return root;
    }
    public void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.right);
        sum += node.val;
        node.val = sum;
        dfs(node.left);
    }
}
```
# BFS
* Time Complexity: O(N)
* Space Complexity: O(N)
    * N as nodes in tree
```
class Solution {
    public TreeNode bstToGst(TreeNode root) {
        if(root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack();
        int sum = 0;
        TreeNode node = root;
        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            sum += node.val;
            node.val = sum;
            node = node.left;
        }
        return root;
    }
}
```