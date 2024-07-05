# Construct Binary Tree from Inorder and Postorder Traversal

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
- Space Complexity: O(N)
  - N as nodes in tree

```
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1,
                         postorder, 0, postorder.length - 1);
    }
    public TreeNode buildTree(int[] inorder, int inStart, int inEnd,
                              int[] postorder, int postStart, int postEnd){
        if(inStart > inEnd){
            return null;
        }
        int rootVal = postorder[postEnd];
        int index = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(rootVal == inorder[i]){
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inorder, inStart, index - 1,
                              postorder, postStart, postStart + leftSize - 1);
        root.right = buildTree(inorder, index + 1, inEnd,
                               postorder, postStart + leftSize, postEnd - 1);
        return root;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as nodes in tree

```
class Solution {
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return find(inorder, 0, inorder.length-1,
                    postorder, 0, postorder.length-1);
    }

    public TreeNode find(int[] inorder, int inStart, int inEnd,
                         int[] postorder, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }
        int rootIndex = map.get(postorder[postEnd]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        int left = rootIndex - inStart;
        root.left = find(inorder, inStart, rootIndex-1,
                         postorder, postStart, postStart + left-1);
        root.right = find(inorder, rootIndex+1, inEnd,
                          postorder, postStart + left, postEnd-1);
        return root;
    }
}
```
