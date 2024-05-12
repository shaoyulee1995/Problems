# Path Sum III
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
* Time Complexity: O(N<sup>2</sup>)
* Space Complexity: O(N)
	* N as nodes in tree 
```
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        int n = dfs(root, targetSum),
            left = pathSum(root.left, targetSum),
            right = pathSum(root.right, targetSum);
        return n+left+right;
    }
    public int dfs(TreeNode root, int targetSum){
        if(root == null){
            return 0;
        }
        int sum = 0;
        if(targetSum == root.val){
            sum++;
        }
        sum += dfs(root.left, targetSum - root.val);
        sum += dfs(root.right, targetSum - root.val);
        return sum;
    }
}
```
# Prefix Sum
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as nodes in tree 
```
class Solution {
    HashMap<Integer, Integer> map = new HashMap();
    int count = 0, k = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        k = targetSum;
        dfs(root, 0);
        return count;
    }
    public void dfs(TreeNode root, int curSum){
        if(root == null){
            return;
        }
        curSum += root.val;
        if(curSum == k){
            count++;
        }
        count += map.getOrDefault(curSum - k, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        dfs(root.left, curSum);
        dfs(root.right, curSum);
        map.put(curSum, map.get(curSum) - 1);
    }
}
```