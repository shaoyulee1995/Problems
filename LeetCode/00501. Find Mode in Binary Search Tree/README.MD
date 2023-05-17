# HashMap
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as nodes
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
class Solution {
    HashMap<Integer, Integer> freq;
    int max;
    public int[] findMode(TreeNode root) {
        freq = new HashMap();
        max = Integer.MIN_VALUE;
        dfs(root);
        List<Integer> list = new ArrayList();
        for(Integer key: freq.keySet()){
            int f = freq.get(key);
            if(f == max){
                list.add(key);
            }
        }
        return list.stream().mapToInt(x->x).toArray();
    }
    public void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        freq.put(node.val, freq.getOrDefault(node.val, 0) + 1);
        max = Math.max(freq.get(node.val), max);
        dfs(node.right);
    }
}
```
# DFS
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as nodes
```
class Solution {
    TreeNode prev;
    int count;
    int maxCount;
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList();
        prev = root;
        dfs(root, list);
        int[] res = new int[list.size()];
        count = 0;
        maxCount = Integer.MIN_VALUE;
        for(int i = 0; i < res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public void dfs(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        dfs(node.left, list);
        count = (prev.val == node.val)? count+1: 1;
        if(count == maxCount){
            list.add(node.val);
        }else if(count > maxCount){
            maxCount = count;
            list.clear();
            list.add(node.val);
        }
        prev = node;
        dfs(node.right, list);
    }
}
```