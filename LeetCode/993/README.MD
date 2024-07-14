# Cousins in Binary Tree

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
- Space Complexity: O(1)
  - N as nodes in tree

```java
class Solution{
    TreeNode xParent, yParent;
    int xDepth, yDepth;
    public boolean isCousins(TreeNode root, int x, int y) {
        xParent = null;
        yParent = null;
        xDepth = -1;
        yDepth = -1;
        dfs(root, x, y, 0, null);
        return xDepth == yDepth && xParent != yParent;
    }
    public void dfs(TreeNode node, int x, int y, int depth, TreeNode parent){
        if(node == null){
            return;
        }
        if(xParent != null && yParent != null){
            return;
        }
        if(node.val == x){
            xParent = parent;
            xDepth = depth;
        }else if(node.val == y){
            yParent = parent;
            yDepth = depth;
        }
        dfs(node.left, x, y, depth+1, node);
        dfs(node.right, x, y, depth+1, node);
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as nodes in tree

```java
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean isX = false,
                    isY = false;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.val == x){
                    isX = true;
                }
                if(node.val == y){
                    isY = true;
                }
                if(node.left != null && node.right != null){
                    if(node.left.val == x && node.right.val == y){
                        return false;
                    }
                    if(node.left.val == y && node.right.val == x){
                        return false;
                    }
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            if(isX && isY){
                return true;
            }
        }
        return false;
    }
}
```
