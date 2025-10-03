# Serialize and Deserialize N-ary Tree

```java
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
```
- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as nodes in tree

```java
class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        List<String> res = new ArrayList();
        serialize(res, root);
        return String.join(",", res);
    }

    private void serialize(List<String> res, Node node){
        if(node == null){
            return;
        }
        res.add(String.valueOf(node.val));
        res.add(String.valueOf(node.children.size()));
        for(Node child: node.children){
            serialize(res, child);
        }
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data == null || data.length() == 0){
            return null;
        }
        String[] values = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(values));
        return deserialize(queue);
    }

    private Node deserialize(Queue<String> queue){
        if(queue.isEmpty()){
            return null;
        }
        Node node = new Node();
        node.val = Integer.parseInt(queue.poll());
        int size = Integer.parseInt(queue.poll());
        node.children = new ArrayList<Node>(size);
        for(int i = 0; i < size; i++){
            node.children.add(deserialize(queue));
        }
        return node;
    }
}
```