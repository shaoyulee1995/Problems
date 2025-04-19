# Lowest Common Ancestor of a Binary Tree III

```
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
```

- Time Complexity: O(P+Q)
- Space Complexity: O(1)
  - P as length of p
  - Q as length of q

```java
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p,
             b = q;
        while(a != b){
            a = (a == null)?q: a.parent;
            b = (b == null)?p: b.parent;
        }
        return a;
    }
}
```

- Time Complexity: O(P+Q)
- Space Complexity: O(Max(P, Q))
  - P as height of p
  - Q as height of q

```java
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> seen = new HashSet();
        while(p != null){
            seen.add(p);
            p = p.parent;
        }
        while(q != null){
            if(seen.contains(q)){
                return q;
            }
            q = q.parent;
        }
        return null;
    }
}
```
