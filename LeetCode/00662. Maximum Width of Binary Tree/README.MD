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
	* N as nodes in tree
```
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        Pair<TreeNode, Integer> p = new Pair<>(root, 0);
        LinkedList<Pair> q = new LinkedList();
        q.offer(p);
        int res = Integer.MIN_VALUE;
        while(!q.isEmpty()){    
            int size = q.size();
            int cmp = (Integer)q.peekLast().getValue() - (Integer)q.peekFirst().getValue() + 1;
            res = Math.max(res, cmp);
            for(int i = 0; i < size; i++){
                Pair<TreeNode, Integer> curPair = q.remove();
                TreeNode node = curPair.getKey();
                Integer index = curPair.getValue();
                if(node.left != null){
                    q.add(new Pair<>(node.left, 2*index));
                }
                if(node.right != null){
                    q.add(new Pair<>(node.right, 2*index+1));
                }
            }
        }
        return res;
    }
}
```