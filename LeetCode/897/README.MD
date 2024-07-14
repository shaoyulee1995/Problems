# Increasing Order Search Tree

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

# In Order Traversal

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as number of nodes in tree

```java
class Solution{
    List<TreeNode> res;
    public TreeNode increasingBST(TreeNode root) {
        res = new ArrayList();
        TreeNode dummyHead = new TreeNode(),
                 tempHead = dummyHead;
        traverse(root);
        for(TreeNode node: res){
            tempHead.right = new TreeNode(node.val);
            tempHead = tempHead.right;
        }

        return dummyHead.right;
    }
    public void traverse(TreeNode node){
        if(node == null){
            return;
        }
        traverse(node.left);
        res.add(node);
        traverse(node.right);
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as number of nodes in tree

```java
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        return increasingBST(root, null);
    }
    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if(root == null){
            return tail;
        }
        TreeNode ans = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return ans;
    }
}
```
