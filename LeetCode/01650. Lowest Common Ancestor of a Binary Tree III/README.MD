```
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
```
# Tree
* Time Complexity: O(P+Q)
* Space Complexity: O(1)
	* P as length of p
	* Q as length of q
```
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