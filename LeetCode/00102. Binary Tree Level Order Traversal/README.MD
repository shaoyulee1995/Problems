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
	* N as number of TreeNode
```
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> lvl = new ArrayList();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                lvl.add(node.val);
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            res.add(lvl);
        }
        
        return res;
    }
}
```
# DFS
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as number of TreeNode
```
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList();
        dfs(root, 0);
        return res;
    }
    public void dfs(TreeNode node, int height){
        if(node == null){
            return;
        }
        if(res.size() <= height){
            res.add(new ArrayList());
        }
        res.get(height).add(node.val);
        if(node.left != null){
            dfs(node.left, height + 1);
        }
        if(node.right != null){
            dfs(node.right, height + 1);
        }
    }
}
```