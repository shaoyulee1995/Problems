```/**
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
# Recursion with Memorization
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    HashMap<TreeNode, Integer> map = new HashMap();
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(map.containsKey(root)){
            return map.get(root);
        }
        int rob = root.val  
            + (root.left == null ? 0: rob(root.left.left) + rob(root.left.right))
            + (root.right == null ? 0: rob(root.right.left) + rob(root.right.right));
        int notRob = rob(root.left) + rob(root.right);
        int res = Math.max(rob, notRob);
        map.put(root, res);
        return res;
    }
}
```