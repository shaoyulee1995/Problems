# N-ary Tree Level Order Traversal

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
  - N as number of Node

```java
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null){
            return res;
        }
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList();
            while(size-- > 0){
                Node node = queue.poll();
                list.add(node.val);
                for(Node child: node.children){
                    queue.add(child);
                }
            }
            res.add(list);
        }
        return res;
    }
}
```
