# Populating Next Right Pointers in Each Node II

```
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
```

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> q = new LinkedList();
        Node dummy = root;
        q.offer(dummy);
        while(!q.isEmpty()){
            int size = q.size();
            Node prev = null;
            for(int i = 0; i < size; i++){
                Node node = q.poll();
                if(i == 0){
                    prev = node;
                }else{
                    prev.next = node;
                    prev = node;
                }
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            prev.next = null;
        }
        return root;
    }
}
```
