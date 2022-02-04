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
    List<List<Integer>> list = new ArrayList();
    LinkedList<Integer> path = new LinkedList();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return list;
        }
        dfs(root, targetSum);
        return list;
    }
    public void dfs(TreeNode root, int targetSum){
        if(root == null){
            return;
        }
        path.add(root.val);
        targetSum -= root.val;
        if(targetSum == 0 && root.left == null && root.right == null){
            list.add(new ArrayList(path));
            path.removeLast();
            return;
        }else{
            dfs(root.left, targetSum);
            dfs(root.right, targetSum);
        }
        path.removeLast();
    }
}
```