```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
```
# DFS
* Time Complexity: O(NClog(C))
* Space Complexity: O(N)
	* C as column nodes in tree
	* N as number of nodes in tree
```
class Solution {
    TreeMap<Integer, List<int[]>> map;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        map = new TreeMap();
        dfs(root, 0, 0);
        List<List<Integer>> list = new ArrayList();
        for(Integer key: map.keySet()){
            List<int[]> arr = map.get(key);
            Collections.sort(arr, (a, b)->a[0] - b[0]);
            List<Integer> nums = new ArrayList();
            for(int i = 0; i < arr.size(); i++){
                nums.add(arr.get(i)[1]);
            }
            list.add(nums);
        }
        return list;
    }
    public void dfs(TreeNode root, int depth, int offset){
        if(root == null){
            return;
        }
        if(!map.containsKey(offset)){
            map.put(offset, new LinkedList());
        }
        map.get(offset).add(new int[]{depth, root.val});
        dfs(root.left,  depth+1, offset-1);
        dfs(root.right, depth+1, offset+1);
    }
}
```
# BFS
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as number of nodes in tree
```
class Solution {
    TreeMap<Integer, List<Integer>> map;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        map = new TreeMap();
        List<List<Integer>> list = new ArrayList();
        bfs(root);
        for(List<Integer> vals: map.values()){
            list.add(vals);
        }
        return list;
    }
    public void bfs(TreeNode root){
        if(root == null){
            return;
        }
        class Pair{
            TreeNode node;
            int offset;
            public Pair(TreeNode node, int offset){
                this.offset = offset;
                this.node = node;
            }
        }
        Queue<Pair> q = new LinkedList();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair cur = q.poll();
                if(!map.containsKey(cur.offset)){
                    map.put(cur.offset, new LinkedList());
                }
                map.get(cur.offset).add(cur.node.val);
                if(cur.node.left != null){
                    q.offer(new Pair(cur.node.left, cur.offset-1));
                }
                if(cur.node.right != null){
                    q.offer(new Pair(cur.node.right, cur.offset+1));
                }
            }
        }
    }
}
```