# All Nodes Distance K in Binary Tree
```
Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
```
# Graph, HashMap, BFS
* Time Complexity: O(E + V)
* Space Complexity: O(E)
	* E as edges
	* V as vertices

```
class Solution {
    HashMap<TreeNode, List<TreeNode>> map;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        map = new HashMap();
        build(root, null);
        HashSet<TreeNode> seen = new HashSet();
        Queue<TreeNode> q = new LinkedList();
        q.offer(target);
        seen.add(target);
        List<Integer> res = new ArrayList();
        while(!q.isEmpty()){
            int size = q.size();
            if(k == 0){
               while(size-- > 0){
                   res.add(q.poll().val);
               }
               return res; 
            } 
            while(size-- > 0){
                TreeNode cur = q.poll();
                for(TreeNode next: map.get(cur)){
                    if(seen.contains(next)){
                        continue;
                    }
                    q.offer(next);
                    seen.add(next);
                }
            }
            k--;
        }
        return res;
    }
    
    public void build(TreeNode node, TreeNode parent){
        if(node == null){
            return;
        }
        map.put(node, new ArrayList<TreeNode>());
        if(parent != null){
            map.get(node).add(parent);
            map.get(parent).add(node);
        }
        build(node.left, node);
        build(node.right, node);
    }
}
```