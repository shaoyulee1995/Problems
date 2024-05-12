# Deepest Leaves Sum
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
    * N as nodes in tree
```
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        LinkedList<TreeNode> bfs = new LinkedList();
        int res = 0, i;
        bfs.offer(root);
        while(!bfs.isEmpty()){
            int size = bfs.size();
            for(i = 0, res = 0; i < size; i++){
                TreeNode node = bfs.poll();
                res += node.val;
                if(node.left != null){
                    bfs.offer(node.left);
                }
                if(node.right != null){
                    bfs.offer(node.right);
                }
            }
        }
        return res;
    }
}
```
# DFS
* Time Complexity: O(N)
* Space Complexity: O(N)
    * N as nodes in tree
```
class Solution {
    int maxDepth = 0,
        sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        deepestLeavesSum(root, 0);
        return sum;
    }
    public void deepestLeavesSum(TreeNode root, int depth){
        if(root == null){
            return;
        }
        if(maxDepth < depth){
            maxDepth = depth;
            sum = root.val;
        }else if(maxDepth == depth){
            sum += root.val;
        }
        deepestLeavesSum(root.right, depth+1);
        deepestLeavesSum(root.left, depth+1);
        
    }
}
```