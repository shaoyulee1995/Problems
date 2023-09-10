# Arrays
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of nums
```
class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int f = 0;
        for(int i = 0; i < nums.length; i++){
            f += i*nums[i];
        }
        int res = f;
        for(int i = nums.length-1; i >= 1; i--){
            res = Math.max(res, sum+f-(nums.length*nums[i]));
            f = sum+f-(nums.length*nums[i]);
        }
        return res;
    }
}
```