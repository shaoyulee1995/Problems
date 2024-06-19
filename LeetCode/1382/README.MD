# Balance a Binary Search Tree

```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
```

# inOrder

- Time Complexity: O(N)
- Space Complexity: O(N)

```
class Solution {
    List<TreeNode> list;
    public TreeNode balanceBST(TreeNode root) {
        list = new ArrayList();
        if(root == null){
            return null;
        }
        inOrder(root);
        return buildTree(0, list.size()-1);
    }
    public void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        list.add(node);
        inOrder(node.right);
    }
    public TreeNode buildTree(int i, int j){
        if(i > j){
            return null;
        }
        int mid = i + (j-i)/2;
        TreeNode root = list.get(mid);
        root.left = buildTree(i, mid-1);
        root.right = buildTree(mid+1, j);
        return root;
    }
}
```
