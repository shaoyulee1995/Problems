# Maximum Sum BST in Binary Tree

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

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution{
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        isBST(root);
        return maxSum;
    }
    class Result{
        int lower, upper, sum;
        public Result(int lower, int upper, int sum){
            this.lower = lower;
            this.upper = upper;
            this.sum = sum;
        }
    }
    public Result isBST(TreeNode root){
        if(root == null){
            return new Result(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Result left = isBST(root.left);
        Result right = isBST(root.right);

        if(left == null || right == null){
            return null;
        }
        if(root.val <= left.upper || root.val >= right.lower){
            return null;
        }
        maxSum = Math.max(maxSum, left.sum + right.sum + root.val);
        int lower = Math.min(root.val, left.lower);
        int upper = Math.max(root.val, right.upper);
        return new Result(lower, upper, left.sum+right.sum+root.val);
    }
}
```
