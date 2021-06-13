/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> q = new LinkedList();
        q.addLast(root);
        while(!q.isEmpty()){
            TreeNode cur = q.removeFirst();
            if(cur == null){
                sb.append("null,");
            }else{
                sb.append(cur.val + ",");
                q.addLast(cur.left);
                q.addLast(cur.right);
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null")){
            return null;
        }
        String[] nodes = data.split(",");
        Deque<TreeNode> q = new ArrayDeque();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.addLast(root);
        int i = 1;
        while(q.size() > 0){
            TreeNode cur = q.removeFirst();
            cur.left = nodes[i].equals("null")?null:new TreeNode(Integer.parseInt(nodes[i]));
            cur.right = nodes[i+1].equals("null")?null:new TreeNode(Integer.parseInt(nodes[i+1]));
            if(cur.left != null){
                q.addLast(cur.left);
            }
            if(cur.right != null){
                q.addLast(cur.right);
            }
            i+=2;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));