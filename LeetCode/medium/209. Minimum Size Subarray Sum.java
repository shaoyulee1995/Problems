class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, len = Integer.MAX_VALUE, val = 0;
        for(int i = 0; i < nums.length; i++){
            val += nums[i];
            while(val >= target){
                len = Math.min(len, i - left + 1);
                val -= nums[left++];
            }
        }
        return (len==Integer.MAX_VALUE)?0: len;
    }
}