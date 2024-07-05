# Merge Two Binary Trees

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

- Time Complexity: O(Max(M, N))
- Space Complexity: O(Max(M, N))

```
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }
        TreeNode mergeTree = new TreeNode(root1.val + root2.val);
        mergeTree.left = mergeTrees(root1.left, root2.left);
        mergeTree.right = mergeTrees(root1.right, root2.right);
        return mergeTree;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)

```
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null){
            return root1==null?root2:root1;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root1);
        queue.add(root2);
        while(!queue.isEmpty()){
            TreeNode L = queue.remove(),
                     R = queue.remove();
            L.val += R.val;
            if(L.left != null && R.left != null){
                queue.add(L.left);
                queue.add(R.left);
            }else if(L.left == null){
                L.left = R.left;
            }

            if(L.right != null && R.right != null){
                queue.add(L.right);
                queue.add(R.right);
            }else if(L.right == null){
                L.right = R.right;
            }
        }
        return root1;
    }
}
```
