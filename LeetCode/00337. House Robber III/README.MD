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
# Memorization Recursion
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
        int rob = root.val + 
                  (root.left != null? rob(root.left.left) + rob(root.left.right): 0) + 
                  (root.right != null? rob(root.right.left) + rob(root.right.right): 0);  
        int not_rob = rob(root.left) + rob(root.right);
        int val = Math.max(rob, not_rob);
        map.put(root, val);
        return val;
    }
}
```
# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }
    private int[] robSub(TreeNode root){
        if(root == null){
            return new int[2];
        }
        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
```