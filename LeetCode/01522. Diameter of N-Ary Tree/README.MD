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
# DFS
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of nums
```
class Solution {
    int path = 0;
    public int diameter(Node root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return path;
    }
    public int dfs(Node node){
        if(node.children.size() == 0){
            return 0;
        }
        int maxOne = -1,
            maxTwo = -1;
        for(Node child: node.children){
            int childHeight = dfs(child);
            if(childHeight > maxOne){
                maxTwo = maxOne;
                maxOne = childHeight;
            }else if(childHeight > maxTwo){
                maxTwo = childHeight;
            }
        }
        path = Math.max(path, maxOne + maxTwo + 2);
        return maxOne + 1;
    }
}
```