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
* Time Complexity: O(N)
* Space Complexity: O(1)

## Java
```
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }
    public boolean isSymmetricHelper(TreeNode l, TreeNode r) {
        if(l == null && r == null){
            return true;
        }
        if(l == null || r == null || r.val != l.val){
            return false;
        }
        return isSymmetricHelper(l.right, r.left) && isSymmetricHelper(l.left, r.right);
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
```
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode son1 = queue.poll(),
                     son2 = queue.poll();
            
            if(son1 == null && son2 == null){
                continue;
            }
            if(son1 == null || son2 == null || son1.val != son2.val){
                return false;
            }
            
            queue.add(son1.left);
            queue.add(son2.right);
            queue.add(son1.right);
            queue.add(son2.left);
        }
        return true;
    }
```