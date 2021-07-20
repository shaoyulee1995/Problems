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
* Time Complexity: O(log(N))
* Space Complexity: O(1)
```
class Solution {
    TreeNode me = null;
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){  
            return null;    
        }
        if(searchInBST(root, val)){
            return me;
        }
        return null;
    }
    public boolean searchInBST(TreeNode root, int val){
        if(root == null){
            return false;
        }
        if(root.val == val){
            me = root;
            return true;
        }
        if(root.val < val){
            return searchInBST(root.right, val);
        }
        return searchInBST(root.left, val);
    }
}
```

# Iteration
* Time Complexity: O(log(N))
* Space Complexity: O(1)

```
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null && root.val != val){
            root = ((root.val<val)?root.right: root.left);
        }
        return root;
    }
}
```