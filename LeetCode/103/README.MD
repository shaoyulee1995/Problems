# Binary Tree Zigzag Level Order Traversal

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

# BFS

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as number of nodes

```
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        boolean shift = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> arr = new LinkedList();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(shift){
                    arr.add(0, node.val);
                }else{
                    arr.add(node.val);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            shift = !shift;
            res.add(arr);
        }
        return res;
    }
}
```
