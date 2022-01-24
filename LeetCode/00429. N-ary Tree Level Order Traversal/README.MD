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
# Iterate
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as number of Node
```
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList();
        if(root == null){
            return list;
        }
        Queue<Node> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> val = new ArrayList();
            for(int i = 0; i < size; i++){
                Node node = q.poll();
                val.add(node.val);
                for(Node child: node.children){
                    q.offer(child);
                }
            }
            list.add(val);
        }
        return list;
    }
}
```