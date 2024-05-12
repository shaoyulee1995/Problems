# Populating Next Right Pointers in Each Node
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
# Recursion
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        connect(root.left, root.right);
        return root;
    }
    public void connect(Node node1, Node node2){
        if(node1==null || node2==null){
            return;
        }
        node1.next = node2;
        
        connect(node1.left, node1.right);
        connect(node2.left, node2.right);
        connect(node1.right, node2.left);
    }
}
```
# Iterate
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as number of TreeNode
```
class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Node dummy = new Node();
        dummy.next = root;
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node prev = null;
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                if(i == 0){
                    prev = node;
                }else{
                    prev.next = node;
                    prev = node;
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            prev.next = null;
        }
        return dummy.next;
    }
}
```