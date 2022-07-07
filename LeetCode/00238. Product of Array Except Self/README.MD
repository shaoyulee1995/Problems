# Prefix Sum 
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for(int i = 1; i < nums.length; i++){
            ans[i] = ans[i-1] * nums[i - 1];
        }
        
        int R = 1;
        for(int i = nums.length - 1; i >=0; i--){
            ans[i] *= R;
            R *= nums[i];
        }
        return ans;
    }
}
```
# 2 Prefix Sum 
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] R = new int[n],
              L = new int[n];
        R[0] = 1;
        int val = 1;
        for(int i = 1; i < nums.length; i++){
            R[i] = nums[i-1] * val;
            val = R[i];
        }
        val = 1;
        L[n-1] = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            L[i] = nums[i+1] * val;
            val = L[i];
        }
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = L[i] * R[i];
        }
        return res;
    }
}
```