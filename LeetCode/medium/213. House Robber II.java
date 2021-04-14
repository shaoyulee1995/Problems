class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(robJump(nums, 0, nums.length - 2),
                        robJump(nums, 1, nums.length - 1));
    }
    
    public int robJump(int[] nums, int start, int end){
        
        int include = 0, 
            exclude = 0;
        for(int i = start; i <= end; i++){
            int add = include, 
                notadd = exclude;
            include = notadd + nums[i];
            exclude = Math.max(notadd, add);
        }
        return Math.max(include, exclude);
    }
}