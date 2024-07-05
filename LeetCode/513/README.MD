# Find Bottom Left Tree Value

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

- Time Complexity: O(N)
- Space Complexity: O(1)

```
class Solution {
    int h, res;
    public int findBottomLeftValue(TreeNode root) {
        h = 0;
        res = 0;
        findBottomLeftValue(root, 1);
        return res;
    }
    public void findBottomLeftValue(TreeNode root, int depth){
        if(h < depth){
            h = depth;
            res = root.val;
        }
        if(root.left != null){
            findBottomLeftValue(root.left, depth+1);
        }
        if(root.right != null){
            findBottomLeftValue(root.right, depth+1);
        }
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)

```
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        LinkedList<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            res = q.peekFirst().val;
            for(int i = 0; i < size; i++){
                TreeNode node = q.remove();
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
        }
        return res;
    }
}
```
