# Most Frequent Subtree Sum

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

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as nodes in tree

```
class Solution {
    HashMap<Integer, Integer> map;
    int maxFreq = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap();
        dfs(root);
        List<Integer> res = new ArrayList();
        for(int key: map.keySet()){
            if(map.get(key) == maxFreq){
                res.add(key);
            }
        }
        return res.stream().mapToInt(x->x).toArray();
    }

    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int sum = dfs(node.left) + dfs(node.right) + node.val;
        map.put(sum, map.getOrDefault(sum, 0)+1);
        maxFreq = Math.max(maxFreq, map.get(sum));
        return sum;
    }
}
```
