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
# Divide and Conquer
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                              int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd){
            return null;
        }
        int rootVal = preorder[preStart];
        int inOrderIndex = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == rootVal){
                inOrderIndex = i;
                break;
            }
        }
        int leftSize = inOrderIndex - inStart;
        
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder,preStart + 1, preStart + leftSize,
                              inorder, inStart, inOrderIndex - 1);
        root.right = buildTree(preorder,preStart+leftSize + 1, preEnd, 
                               inorder, inOrderIndex + 1, inEnd);
        return root;
        
    }
}
```