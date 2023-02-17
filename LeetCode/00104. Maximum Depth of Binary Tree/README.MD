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
# Recursion
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left),
            right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
```
# BFS
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        int res = 0;        
        while(!q.isEmpty()){
            int size = q.size();
            while(size != 0){
                TreeNode node = q.poll();
                size--;
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            res++;
        }
        return res;
    }
}
```