```
/*
// Definition for a Node.
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
*/
```
# Recursion 
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    List<Integer> list = new ArrayList();
    public List<Integer> preorder(Node root) {
        if(root == null){
            return new ArrayList();
        }
        list.add(root.val);
        for(Node child: root.children){
            preorder(child);
        }
        return list;
    }
}
```

# Iterate
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList();
        if(root == null){
            return list;
        }
        Stack<Node> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            list.add(node.val);
            for(int i = node.children.size() - 1; i >=0 ; i--){
                stack.push(node.children.get(i));
            }
        }
        return list;
    }
}
```
