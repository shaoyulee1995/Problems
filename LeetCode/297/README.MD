# Serialize and Deserialize Binary Tree
```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
```
# BFS
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as nodes in tree
```
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }
    public void preOrder(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("#").append(",");
            return;
        }
        sb.append(node.val).append(",");
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList();
        for(String node: data.split(",")){
            list.add(node);
        }
        return decodePreOrder(list);
    }
    public TreeNode decodePreOrder(LinkedList<String> list){
        String val = list.removeFirst();
        if(val.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = decodePreOrder(list);
        root.right =decodePreOrder(list);
        return root;
    }
}
```
```
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
```