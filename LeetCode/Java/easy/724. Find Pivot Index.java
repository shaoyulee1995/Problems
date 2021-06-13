class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum+=num;
        }
        
        int prevSum = 0;
        for(int i = 0; i < nums.length; i++){
            if(prevSum == sum - nums[i] - prevSum){
                return i;
            }
            prevSum += nums[i];
        }
        return -1;
    }
}