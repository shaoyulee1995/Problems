# 2 Pointers
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of nums
```
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
```
# 2 Pointers
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of nums
```
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int cur_right = 0, 
            res = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i-1] >= nums[i]){
                cur_right = 1;
            }else{
                cur_right++;
            }
            res = Math.max(cur_right, res);
        }
        return res;
    }
}
```
# DP
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
            }
            res = Math.max(res, dp[i]);
            
        }
        return res;
    }
}
```