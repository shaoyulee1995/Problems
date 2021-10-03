class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        if(nums.length < 5){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++){
            res = Math.min(res, nums[nums.length - 4 + i] - nums[i]);
        }
        return res;
    }
}