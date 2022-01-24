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
# BFS
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        int min = Integer.MAX_VALUE;
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(node.left == null && node.right == null){
                    min = Math.min(level, min);
                }
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
        }
        return min;
    }
}
```
# Recursion 1
* Time Complexity: O(N)
* Space Complexity: O(1)
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

# Recursion 2
* Time Complexity: O(N)
* Space Complexity: O(1)
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