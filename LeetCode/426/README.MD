# Convert Binary Search Tree to Sorted Doubly Linked List

```java
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as the number of nodes in the tree

```java
class Solution {
    Node head, prev;
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        head = null;
        prev = null;
        dfs(root);
        prev.right = head;
        head.left = prev;
        return head;
    }

    private void dfs(Node node){
        if(node == null){
            return;
        }

        dfs(node.left);
        if(prev == null){
            head = node;
        }else{
            prev.right = node;
            node.left = prev;
        }
        prev = node;
        dfs(node.right);
    }
}
```