# Binary Tree Zigzag Level Order Traversal

```
Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as number of nodes

```java

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque();
        queue.offer(root);
        boolean shift = false;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayDeque<Integer> tmp = new ArrayDeque();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();   
                if(shift){
                    tmp.offerFirst(node.val);
                }else{
                    tmp.addLast(node.val);
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(new ArrayList(tmp));
            shift = !shift;
        }
        return res;
    }
}
```
