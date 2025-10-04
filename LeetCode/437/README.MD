# Path Sum III

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

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
  - N as nodes in tree

```java
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

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as nodes in tree

```java
class Solution {
    int res, targetSum;
    HashMap<Long, Integer> map;

    public int pathSum(TreeNode root, int targetSum) {
        map = new HashMap();
        res = 0;
        this.targetSum = targetSum;
        preOrder(root, 0l);
        return res;
    }

    private void preOrder(TreeNode node, long currentSum) {
        if (node == null) {
            return;
        }
        currentSum += node.val;

        if (currentSum == targetSum) {
            res++;
        }

        res += map.getOrDefault(currentSum - targetSum, 0);

        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);

        preOrder(node.left, currentSum);
        preOrder(node.right, currentSum);

        map.put(currentSum, map.get(currentSum) - 1);
        if (map.get(currentSum) == 0) {
            map.remove(currentSum);
        }
    }
}
```
