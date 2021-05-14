class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int left = 0, right = left + 1;
        int res = 1;
        while(right < nums.length){
            while(right < nums.length && nums[right] > nums[right - 1]){
                res = Math.max(res, right - left + 1);
                right++;
            }
            left = right;
            right++;
        }
        return res;
    }
}