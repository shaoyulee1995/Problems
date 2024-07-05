# Delete Node in a BST

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

- Time Complexity: O(logN)
- Space Complexity: O(1)

```
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val == key){
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            TreeNode min = getMin(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else if(root.val > key){
            root.left =  deleteNode(root.left, key);
        }
        return root;
    }
    public TreeNode getMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}
```
