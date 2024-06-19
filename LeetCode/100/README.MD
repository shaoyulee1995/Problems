# Same Tree

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

# Recursion

- Time Complexity: O(N)
- Space Complexity: O(N)

```
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
```

# Iterator

- Time Complexity: O(N)
- Space Complexity: O(N)

```
class Solution {
    public boolean isSameTree(TreeNode a, TreeNode b) {
        Queue<TreeNode> q = new LinkedList();
        q.add(a);
        q.add(b);
        while(!q.isEmpty()){
            TreeNode pchild = q.poll();
            TreeNode qchild = q.poll();
            if(pchild == null && qchild == null){
                continue;
            }
            if(pchild == null || qchild == null){
                return false;
            }
            if(pchild.val != qchild.val){
                return false;
            }
            q.add(pchild.left);
            q.add(qchild.left);
            q.add(pchild.right);
            q.add(qchild.right);
        }
        return true;
    }
}
```
