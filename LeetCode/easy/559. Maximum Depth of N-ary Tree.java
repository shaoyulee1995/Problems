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

class Solution {
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        Queue<Node> q = new LinkedList();
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node node = q.poll();
                for(Node child: node.children){
                    q.offer(child);
                }
            }
            level++;
        }
        return level;
    }
}