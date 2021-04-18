class Solution {
    public int minOperations(int[] nums) {
        int diff = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i]<=nums[i-1]){
                int temp = nums[i];
                nums[i] = nums[i-1] + 1;
                diff += Math.abs(nums[i] - temp);
            }            
        }
        return diff;
    }
}