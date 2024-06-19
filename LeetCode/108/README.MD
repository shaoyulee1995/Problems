# Convert Sorted Array to Binary Search Tree

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

# DFS

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length-1);
    }

    public TreeNode build(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int node = start + (end-start)/2;
        TreeNode root = new TreeNode(nums[node]);
        root.left = build(nums, start, node-1);
        root.right = build(nums, node+1, end);
        return root;
    }
}
```
