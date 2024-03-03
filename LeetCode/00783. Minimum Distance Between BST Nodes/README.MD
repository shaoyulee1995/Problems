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
    TreeNode prev;
    Integer res;
    public int minDiffInBST(TreeNode root) {
        prev = null;
        res = Integer.MAX_VALUE;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        if(prev != null){
            res = Math.min(res, node.val - prev.val);
        }
        prev = node;
        dfs(node.right);
    }
}
```
# BFS
* Time Complexity: O(N)
* Space Complexity: O(H)
	* N as nodes in tree
    * H as height of tree 
```
class Solution {
    public int minDiffInBST(TreeNode root) {
        int res = Integer.MAX_VALUE;
        TreeNode node = root,
                 prev = null;
        Stack<TreeNode> stack = new Stack();
        while(node != null || !stack.isEmpty()){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                if(prev != null){
                    res = Math.min(res, Math.abs(node.val - prev.val));
                }
                prev = node;
                node = node.right;
            }
        }
        return res;
    }
}
```