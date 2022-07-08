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
# DFS
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as number of TreeNodes
```
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> findLeaves(TreeNode root) {
        res = new ArrayList();
        dfs(root);
        return res;
    }
    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int height = Math.max(dfs(node.left), dfs(node.right)) + 1;
        if(res.size() < height){
            res.add(new ArrayList());
        }
        res.get(height - 1).add(node.val);
        return height;
    }
}
```