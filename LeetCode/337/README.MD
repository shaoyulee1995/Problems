# House Robber III

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

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution{
    HashMap<TreeNode, Integer> map = new HashMap();
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(map.containsKey(root)){
            return map.get(root);
        }
        int robbed = root.val;
        if(root.left != null){
            robbed += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
            robbed += rob(root.right.left) + rob(root.right.right);
        }
        int robNext = rob(root.left) + rob(root.right);
        int res = Math.max(robbed, robNext);
        map.put(root, res);
        return res;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as nodes in tree

```java
class Solution {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfs(TreeNode node){
        int[] res = new int[2];
        if(node == null){
            return res;
        }
        int[] left = dfs(node.left),
              right = dfs(node.right);
        int rob = node.val + left[1] + right[1],
            notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[0] = rob;
        res[1] = notRob;
        return res;
    }
}
```
