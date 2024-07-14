# Kth Smallest Element in a BST

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

```java
class Solution{
    int res = 0, rank = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }
    public void traverse(TreeNode node, int k){
        if(node == null){
            return;
        }
        traverse(node.left, k);
        rank++;
        if(rank == k){
            res = node.val;
            return;
        }
        traverse(node.right, k);
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as nodes in tree

```java
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inOrder = new ArrayList();
        traverseInOrder(inOrder, root);
        return inOrder.get(k-1);
    }
    public void traverseInOrder(List<Integer> inOrder, TreeNode root){
        if(root == null){
            return;
        }
        traverseInOrder(inOrder, root.left);
        inOrder.add(root.val);
        traverseInOrder(inOrder, root.right);
    }
}
```
