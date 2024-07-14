# N-ary Tree Postorder Traversal

```
/*

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

- Time Complexity: O(N)
- Space Complexity: O(N)

```
class Solution {
    List<Integer> list = new ArrayList();
    public List<Integer> postorder(Node root) {
        if(root == null){
            return list;
        }
        for(Node child: root.children){
            postorder(child);
        }
        list.add(root.val);
        return list;
    }
}
```
