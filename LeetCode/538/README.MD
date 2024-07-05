# Convert BST to Greater Tree

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

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as nodes in tree

```
class Solution {
    int sum;
    public TreeNode convertBST(TreeNode root) {
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

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as nodes in tree

```
class Solution {
    public TreeNode convertBST(TreeNode root) {
        dfs(root, new TreeNode());
        return root;
    }

    public void dfs(TreeNode node, TreeNode prev){
        if(node == null){
            return;
        }
        dfs(node.right, prev);
        node.val += prev.val;
        prev.val = node.val;
        dfs(node.left, prev);
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as nodes in tree

```
class Solution {
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack();
        int sum = 0;
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
