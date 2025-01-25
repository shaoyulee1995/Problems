# Find All The Lonely Nodes

```java
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
  - N is the number of nodes in the tree

```java
class Solution {
    List<Integer> res;
    public List<Integer> getLonelyNodes(TreeNode root) {
        res = new ArrayList();
        dfs(root, false);
        return res;
    }
    private void dfs(TreeNode node, boolean isLonely){
        if(node == null){
            return;
        }
        if(isLonely){
            res.add(node.val);
        }
        dfs(node.left, node.right == null);
        dfs(node.right, node.left == null);
    }
}
```