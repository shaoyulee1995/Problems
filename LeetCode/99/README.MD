# Recover Binary Search Tree

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

```java
class Solution {
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        List<TreeNode> list = new ArrayList();
        TreeNode x = null, y = null;
        dfs(root, list);
        for(int i = 0; i < list.size()-1; i++){
            if(list.get(i).val > list.get(i+1).val){
                y = list.get(i+1);
                if(x == null){
                    x = list.get(i);
                }
            }
        }
        if(x != null && y != null){
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
        return;
    }
    public void dfs(TreeNode node, List<TreeNode> list){
        if(node == null){
            return;
        }
        dfs(node.left, list);
        list.add(node);
        dfs(node.right, list);
    }
}
```
