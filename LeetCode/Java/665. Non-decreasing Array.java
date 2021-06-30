class Solution {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i-1]){
                cnt++;
            }
            if(cnt > 1){
                return false;
            }
            
            if(i-2 >= 0 && i + 1 <nums.length &&
              nums[i-2] > nums[i] && nums[i-1] > nums[i+1]){
                return false;
            }
        }
        
        return true;
    }
}