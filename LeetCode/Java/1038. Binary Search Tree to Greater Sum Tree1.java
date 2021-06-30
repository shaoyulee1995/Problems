
class Solution {
    public TreeNode bstToGst(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int sum = 0;
        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.add(node);
                node = node.right;
            }
            node = stack.pop();
            sum += node.val;
            node.val = sum;
            node = node.left;
        }
        
        return root;
    }
}

