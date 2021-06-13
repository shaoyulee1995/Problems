class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }
        sum /= 2;
        return helper(sum, nums, 0);
    }
    private boolean helper(int target, int[] nums, int index){
        if(target == 0){
            return true;
        }
        if(target < 0 || index == nums.length){
            return false;
        }
        if(helper(target - nums[index], nums, index + 1)){
            return true;
        }
        int j = index + 1;
        while(j < nums.length && nums[j] == nums[index]){
            j++;
        }
        return helper(target, nums, j); 
    }
}