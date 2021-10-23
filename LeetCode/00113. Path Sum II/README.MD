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
# Tree
* Time Complexity: O(N)
* Space Complexity: O(log(N))
```
class Solution {
    List<List<Integer>> res = new ArrayList();
    List<Integer> list = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }
    public void dfs(TreeNode root, int targetSum){
        if(root == null){
            return;
        }
        targetSum -= root.val;
        list.add(root.val);
        if(targetSum == 0 && root.left == null && root.right == null){
            res.add(new ArrayList(list));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        list.remove(list.size() - 1);
    }
}
```