# Symmetric Tree

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
- Space Complexity: O(1)

## Java

```
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
    }
}
```

## C++

```
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if(root == NULL){
            return true;
        }
        return isSymmetric(root->left, root->right);
    }
    bool isSymmetric(TreeNode *left, TreeNode *right){
        if(!left && !right){
            return true;
        }
        if(!left || !right || left->val != right->val){
            return false;
        }
        return isSymmetric(left->left, right->right) && isSymmetric(left->right, right->left);
    }
};
```

# BFS

- Time Complexity: O(N)
- Space Complexity: O(N)

```
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> q = new LinkedList();
        q.offer(root.left);
        q.offer(root.right);
        while(!q.isEmpty()){
            TreeNode l = q.poll(),
                     r = q.poll();
            if(l == null && r == null){
                continue;
            }
            if(l == null || r == null){
                return false;
            }
            if(l.val != r.val){
                return false;
            }
            q.offer(l.left);
            q.offer(r.right);
            q.offer(l.right);
            q.offer(r.left);
        }
        return true;
    }
}
```
