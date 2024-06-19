# Binary Tree Inorder Traversal

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

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as nodes in tree

```
class Solution {
    List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList();
        dfs(root);
        return res;
    }

    public void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        res.add(node.val);
        dfs(node.right);
    }
}
```

# BFS

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as nodes in tree

```
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
```

# Thread Binary Tree(Morris Traversal)

- Time Complexity: O(N)
- Space Complexity: O(N)

```
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if(root == null){
            return list;
        }
        TreeNode cur = root;
        while(cur != null){
            if(cur.left != null){
                TreeNode pre = cur.left;
                while(pre.right != null && pre.right != cur){
                    pre = pre.right;
                }
                if(pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                }else{
                    pre.right = null;
                    list.add(cur.val);
                    cur = cur.right;
                }
            }else{
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }
}
```
