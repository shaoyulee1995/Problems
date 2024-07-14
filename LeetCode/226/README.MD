# Invert Binary Tree

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

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as number of nodes in tree

```java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        final TreeNode left = root.left,
                       right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as number of nodes in tree

```java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode dummy = root;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                swapChildren(node);
            }
        }
        return dummy;
    }

    public void swapChildren(TreeNode node){
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
```
