class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE,
            max = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i-1]){
                min = Math.min(min, nums[i]);
            }
        }
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i]>nums[i+1]){
                max = Math.max(max, nums[i]);
            }
        }
        int i = 0;
        for(; i < nums.length; i++){
            if(nums[i] > min){
                break;
            }
        }
        int j = nums.length - 1;
        for(;j>=0; j--){
            if(nums[j]<max){
                break;
            }
        }
        return (i>j)?0:j-i+1;
    }
}