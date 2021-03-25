class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0 || nums == null)
            return 0;
        Arrays.sort(nums);
        int cur = nums[0],
            max = 1, sum = 1;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1])
                continue;
            if(nums[i] == cur + 1){
                cur++;
                sum++;
            }else{
                cur = nums[i];
                sum = 1;
            }
            max = Math.max(max, sum);
        }
        return max;
}