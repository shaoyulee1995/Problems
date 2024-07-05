# Minimum Depth of Binary Tree

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
  - N as nodes in tree

```
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        for(int height = 1, size = queue.size(); !queue.isEmpty(); size = queue.size(), height++){
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null){
                    return height;
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return -1;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as nodes in tree

```
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left != null && root.right != null){
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
        return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as nodes in tree

```
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = minDepth(root.left),
            right = minDepth(root.right);
        if(root.left == null && root.right != null){
            return 1 + right;
        }
        if(root.right == null && root.left != null){
            return 1 + left;
        }
        return 1 + Math.min(left, right);
    }
}
```
