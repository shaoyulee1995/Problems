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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        boolean shift = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new LinkedList();
            while(size-- > 0){
                TreeNode node = queue.poll();
                if(shift){
                    temp.add(node.val);
                }else{
                    temp.add(0, node.val);
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            shift = !shift;
            list.add(new ArrayList(temp));
        }
        return list;
    }
}