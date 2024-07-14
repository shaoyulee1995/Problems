# Binary Tree Preorder Traversa

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
  - N as number of TreeNode

```java
class Solution{
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        if(root == null){
            return res;
        }
        preorderTraversal(res, root);
        return res;
    }
    public void preorderTraversal(List<Integer> res, TreeNode root){
        if(root == null){
            return;
        }
        res.add(root.val);
        preorderTraversal(res, root.left);
        preorderTraversal(res, root.right);
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as number of TreeNode

```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node != null){
                res.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return res;
    }
}
```
