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
# Recursion (Cartesian tree)
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }
    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int curMax = start;
        for(int i = start+1; i <= end; i++){
            if(nums[curMax] < nums[i]){
                curMax = i;
            }
        }
        TreeNode root = new TreeNode(nums[curMax]);
        root.left = constructMaximumBinaryTree(nums, start, curMax - 1);
        root.right = constructMaximumBinaryTree(nums, curMax + 1, end);
        return root;
    }
}
```