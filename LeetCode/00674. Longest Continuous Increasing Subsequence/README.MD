# Array
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