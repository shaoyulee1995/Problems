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
```
class Solution {
    int deepest = 0, ans = 0;
    public int deepestLeavesSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        deepestLeavesSum(root, 0);
        return ans;
    }
    public void deepestLeavesSum(TreeNode root, int level) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(deepest == level){
                ans += root.val;
            }else if(deepest < level){
                deepest = level;
                ans = 0;
                ans += root.val;
            }
        }
        deepestLeavesSum(root.left, level + 1);
        deepestLeavesSum(root.right, level + 1);
    }
}
```