# Find Root of N-Ary Tree

```
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
```

# HashSet

- Time Complexity: O(NC)
- Space Complexity: O(N)
  - N as number of Nodes in tree
  - C as maximum node for node.children

```
class Solution {
    public Node findRoot(List<Node> tree) {
        HashSet<Node> set = new HashSet();
        for(Node node: tree){
            for(Node child: node.children){
                set.add(child);
            }
        }
        for(Node node: tree){
            if(!set.contains(node)){
                return node;
            }
        }
        return null;
    }
}
```

# Unique element

- Time Complexity: O(NC)
- Space Complexity: O(1)
  - N as number of Nodes in tree
  - C as maximum node for node.children

```
class Solution {
    public Node findRoot(List<Node> tree) {
        Integer res = 0;
        for(Node node: tree){
            res += node.val;
            for(Node child: node.children){
                res -= child.val;
            }
        }
        for(Node node: tree){
            if(res == node.val){
                return node;
            }
        }
        return null;
    }
}
```
