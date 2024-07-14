# Inorder Successor in BST

```
Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
```

- Time Complexity: O(H)
- Space Complexity: O(1)
  - H as height of tree

```java
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while(root != null){
            if(p.val >= root.val){
                root = root.right;
            }else{
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
}
```
