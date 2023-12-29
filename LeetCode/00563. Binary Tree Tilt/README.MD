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
    int total;
    public int findTilt(TreeNode root) {
        total = 0;
        dfs(root);
        return total;
    }

    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = dfs(node.left), 
            right = dfs(node.right),
            tilt = Math.abs(left - right);
        total += tilt;
        return node.val + left + right;
    }
}
```