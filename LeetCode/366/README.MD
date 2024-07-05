# Find Leaves of Binary Tree

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

# DFS height

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as number of TreeNodes

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

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as number of TreeNodes

```
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        while(root != null){
            List<Integer> path = new LinkedList();
            root = dfs(root, path);
            res.add(new ArrayList(path));
        }
        return res;
    }
    public TreeNode dfs(TreeNode node, List<Integer> path){
        if(node == null){
            return null;
        }
        if(node.left == null && node.right == null){
            path.add(node.val);
            return null;
        }
        node.left = dfs(node.left, path);
        node.right = dfs(node.right, path);
        return node;
    }
}
```
