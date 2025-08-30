# Serialize and Deserialize BST

```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as nodes in tree

```java
public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb){
        if(node == null){
            return;
        }
        sb.append(node.val).append(",");
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0){
            return null;
        }
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode deserialize(Queue<String> queue, int low, int high){
        if(queue.isEmpty()){
            return null;
        }
        String peek = queue.peek();
        int val = Integer.parseInt(peek);
        if(val < low || val > high){
            return null;
        }
        String item = queue.poll();
        int data = Integer.parseInt(item);
        TreeNode node = new TreeNode(data);
        node.left = deserialize(queue, low, data);
        node.right = deserialize(queue, data, high);
        return node;
    }
}
```