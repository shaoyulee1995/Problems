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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(0, nums.length-1, nums);
    }
    
    public TreeNode helper(int start, int last, int[] nums){
        if(start > last){
            return null;
        }
        
        int indexMax = start;
        for(int i = start + 1; i <= last; i++){
            if(nums[i] > nums[indexMax]){
                indexMax = i;
            }
        }
        TreeNode root = new TreeNode(nums[indexMax]);
        root.left = helper(start, indexMax-1, nums);
        root.right = helper(indexMax + 1, last, nums);
        
        return root;
    }
}