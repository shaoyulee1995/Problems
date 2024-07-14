# Binary Tree Level Order Traversal

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
- Space Complexity: O(N)
  - N as nodes in tree

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList();
        }
        List<List<Integer>> res = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        for(int size = queue.size(); !queue.isEmpty(); size = queue.size()){
            List<Integer> row = new ArrayList();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                row.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(row);
        }
        return res;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as nodes in tree

```java
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList();
        dfs(root, 0);
        return res;
    }
    public void dfs(TreeNode node, int height){
        if(node == null){
            return;
        }
        if(res.size() <= height){
            res.add(new ArrayList());
        }
        res.get(height).add(node.val);
        if(node.left != null){
            dfs(node.left, height + 1);
        }
        if(node.right != null){
            dfs(node.right, height + 1);
        }
    }
}
```
