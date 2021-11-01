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
# In Order Traversal
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> values = new ArrayList();
        TreeNode temp = root, newHead = new TreeNode(0), newRoot = newHead;
        inorder(temp, values);
        for(Integer num: values){
            newHead.right = new TreeNode(num);
            newHead = newHead.right;
        }
        return newRoot.right;
    }
    
    public void inorder(TreeNode root, List<Integer> list){
        if(root==null){return;}
        
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        
    }
}
```
# Tree
* Time Complexity: O(N)
* Space Complexity: O(H)

```	
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        return increasingBST(root, null);
    }
    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if(root == null){
            return tail;
        }
        TreeNode ans = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return ans;
    }
}
```