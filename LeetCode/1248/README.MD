# Count Number of Nice Subarrays
# Sliding Windows
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }

    public int atMost(int[] nums, int k){
        int res = 0;
        for(int i = 0, j = 0; j < nums.length; j++){
            k -= nums[j] % 2;
            while(k < 0){
                k += nums[i++] % 2;
            }
            res += j-i+1;
        }
        return res;
    }
}
```