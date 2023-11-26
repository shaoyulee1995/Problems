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
# Iteration
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as nodes in tree
```
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        for(int size = queue.size(); !queue.isEmpty(); size = queue.size()){
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(i == size-1){
                    res.add(node.val);
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}
```
# Recursion
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as nodes in tree
```
class Solution {
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList();
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode node, int level){
        if(node == null){
            return;
        }
        if(res.size() == level){
            res.add(node.val);
        }
        dfs(node.right, level+1);
        dfs(node.left, level+1);
    }
}
```