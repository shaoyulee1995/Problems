# Binary Tree Vertical Order Traversal

```
Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
```

- Time Complexity: O(NClog(C))
- Space Complexity: O(N)
  - C as column nodes in tree
  - N as number of nodes in tree

```java
class Solution {
    TreeMap<Integer, List<int[]>> map;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        map = new TreeMap();
        List<List<Integer>> res = new ArrayList();
        dfs(root, 0, 0);
        for(Integer key: map.keySet()){
            List<int[]> list = map.get(key);
            Collections.sort(list, (a, b) -> a[0] - b[0]);
            List<Integer> tmp = new ArrayList();
            list.stream().forEach(x -> tmp.add(x[1]));
            res.add(tmp);
        }
        return res;
    }

    public void dfs(TreeNode node, int depth, int offset){
        if(node == null){
            return;
        }
        if(!map.containsKey(offset)){
            map.put(offset, new LinkedList());
        }
        map.get(offset).add(new int[]{depth, node.val});
        dfs(node.left, depth+1, offset-1);
        dfs(node.right, depth+1, offset+1);
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as number of nodes in tree

```java
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        if(root == null){
            return list;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap();
        Queue<Integer> cols = new LinkedList();
        Queue<TreeNode> queue = new LinkedList<>();
        cols.add(0);
        queue.add(root);
        int min = 0, max = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int col = cols.poll();

            if(!map.containsKey(col)){
                map.put(col, new ArrayList());
            }
            map.get(col).add(node.val);

            if(node.left != null){
                cols.add(col-1);
                queue.add(node.left);
                min = Math.min(min, col-1);
            }
            if(node.right != null){
                cols.add(col+1);
                queue.add(node.right);
                max = Math.max(max, col+1);
            }
        }
        for(int i = min; i <= max; i++){
            list.add(map.get(i));
        }
        return list;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as number of nodes in tree

```java
class Solution {
    class Pair{
        TreeNode node;
        int col;
        public Pair(TreeNode node, int col){
            this.col = col;
            this.node = node;
        }
    }
    
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
        Queue<Pair> q = new LinkedList();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair cur = q.poll();
                if(!map.containsKey(cur.col)){
                    map.put(cur.col, new LinkedList());
                }
                map.get(cur.col).add(cur.node.val);
                if(cur.node.left != null){
                    q.offer(new Pair(cur.node.left, cur.col-1));
                }
                if(cur.node.right != null){
                    q.offer(new Pair(cur.node.right, cur.col+1));
                }
            }
        }
    }
}
```
