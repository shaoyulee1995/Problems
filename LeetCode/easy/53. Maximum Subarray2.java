class Solution {
    public int maxSubArray(int[] nums) {
        int local = nums[0], global = nums[0];
        for(int i = 1; i < nums.length; i++){
            local = nums[i] + Math.max(0, local);
            global = Math.max(global, local);
        }
        return global;
    }
}