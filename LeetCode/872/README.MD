# Leaf-Similar Trees

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

```java
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> tree1 = new ArrayList(),
                      tree2 = new ArrayList();
        traverse(root1, tree1);
        traverse(root2, tree2);
        if(tree1.size() != tree2.size()){
            return false;
        }
        for(int i = 0; i < tree1.size(); i++){
            if(tree1.get(i) != tree2.get(i)){
                return false;
            }
        }
        return true;
    }
    public void traverse(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            list.add(node.val);
        }
        traverse(node.left, list);
        traverse(node.right, list);
    }
}
```
