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

```
public class Codec {
    String SEP = ",";
    String NULL = "#";
    StringBuilder sb;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return NULL;
        }
        sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    public void serialize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList();
        for(String s: data.split(SEP)){
            list.addLast(s);
        }
        return deserialize(list);
    }
    public TreeNode deserialize(LinkedList<String> list){
        if(list.isEmpty()){
            return null;
        }
        String first = list.removeFirst();
        if(first.equals(NULL)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(list);
        root.right = deserialize(list);
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