```
/*
// Definition for a Node.
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
*/
```
# BFS
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }        
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node temp = new Node(0);
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                temp.next = node;
                temp = temp.next;
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}
```