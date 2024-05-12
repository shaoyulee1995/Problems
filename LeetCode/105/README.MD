# Construct Binary Tree from Preorder and Inorder Traversal
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
	* N as nodes in tree
```
class Solution {
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return find(preorder, 0, preorder.length-1,
                    inorder, 0, inorder.length-1);
    }
    public TreeNode find(int[] preorder, int preStart, int preEnd,
                         int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        int rootIndex = map.get(preorder[preStart]);
        TreeNode root = new TreeNode(preorder[preStart]);
        int left = rootIndex - inStart;
        root.left = find(preorder, preStart+1, preStart+left,
                         inorder, inStart, inStart + rootIndex-1);
        root.right = find(preorder, preStart+left+1, preEnd,
                          inorder, rootIndex+1, inEnd); 
        return root;
    }
}
```
# Backtrack
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as nodes in tree
```
class Solution {
    int[] preOrder;
    int preOrderIndex;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preOrder = preorder;
        map = new HashMap();
        for(int i = 0; i < inorder.length; i ++){
            map.put(inorder[i], i);
        }
        preOrderIndex = 0;
        return buildTree(0, inorder.length-1);
    }
    public TreeNode buildTree(int inOrderStart, int inOrderEnd){
        if(inOrderStart > inOrderEnd){
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preOrderIndex++]);
        int idx = map.get(root.val);
        root.left = buildTree(inOrderStart, idx-1);
        root.right = buildTree(idx+1, inOrderEnd);
        return root;
    }
}
```