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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack = new Stack();
        
        while(!stack.isEmpty()||root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if(root==null){
            return list;
        }
        traversal(root, list);
        return list;
    }
    private void traversal(TreeNode node, List<Integer> list){
        if(node.left != null){
            traversal(node.left, list);
        }
        list.add(node.val);
        if(node.right != null){
            traversal(node.right, list);
        }
    }
}