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
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        list = new ArrayList();
        if(root == null){
            return list;
        }
        boolean flag = false;
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            LinkedList<Integer> nodes = new LinkedList();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(flag){ 
                    nodes.add(0, node.val);
                }else{
                    nodes.add(node.val);
                }
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            list.add(new ArrayList(nodes));
            flag = !flag;
        }
        return list;
    }
}
```