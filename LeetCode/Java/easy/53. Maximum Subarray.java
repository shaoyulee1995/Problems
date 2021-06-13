class Solution {
    public int maxSubArray(int[] nums) {
        int localMax = nums[0],
            globalMax = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            localMax = Math.max(localMax + nums[i], nums[i]);
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }
}

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