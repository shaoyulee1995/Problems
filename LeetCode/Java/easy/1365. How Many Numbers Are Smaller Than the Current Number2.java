class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[102];
        
        for(int i = 0; i < nums.length; i++){
            count[nums[i]+1]++;
        }
        for(int i = 0; i < count.length - 1; i++){
            count[i+1] += count[i];
        }
        
        for(int i = 0; i < nums.length; i++){
            nums[i] = count[nums[i]];
        }
        return nums;
    }
}