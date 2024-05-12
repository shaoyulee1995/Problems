# Product of Array Except Self
# 1 Prefix Sum 
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0, L = 1; i < nums.length; i++){
            res[i] = L;
            L *= nums[i];
        }
        for(int i = nums.length-1, R = 1; i >= 0; i--){
            res[i] *= R;
            R *= nums[i];
        }
        return res;
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