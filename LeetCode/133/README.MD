# Clone Graph

```java
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as the number of nodes in the graph

```java
class Solution {
    public Node cloneGraph(Node head) {
        if(head == null){
            return null;
        }
        HashMap<Node, Node> map = new HashMap();
        Queue<Node> queue = new LinkedList();
        queue.offer(head);
        map.put(head, new Node(head.val, new ArrayList()));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(Node child: node.neighbors){
                if(!map.containsKey(child)){
                    map.put(child, new Node(child.val, new ArrayList()));
                    queue.offer(child);
                }
                map.get(node).neighbors.add(map.get(child));
            }
        }
        return map.get(head);
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as the number of nodes in the graph

```java
class Solution {
    HashMap<Node, Node> graph;
    public Node cloneGraph(Node node) {
        graph = new HashMap();
        return dfs(node);
    }

    public Node dfs(Node node){
        if(node == null){
            return null;
        }
        if(!graph.containsKey(node)){
            return graph.get(node);
        }
        ArrayList<Node> neighbors = new ArrayList();
        Node currentNode = new Node(node.val, neighbors);
        graph.put(node, currentNode);
        if(node.neighbors != null){
            for(Node child: node.neighbors){
                Node clonedChild = dfs(child);
                if(clonedChild != null){
                    neighbors.add(clonedChild);
                }
            }
        }
        return currentNode;
    }
}
```
