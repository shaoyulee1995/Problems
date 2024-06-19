# Average of Levels in Binary Tree

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

# Iterate

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as number of TreeNode

```
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null){
            return new ArrayList();
        }
        List<Double> res = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Double avg = 0.0;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                avg += node.val;
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(new Double(avg/size));
        }
        return res;
    }
}
```
