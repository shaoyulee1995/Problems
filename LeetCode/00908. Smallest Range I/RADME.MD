# Array
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of nums
```
class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt(),
            min = Arrays.stream(nums).min().getAsInt();
        if(min+k < max-k){
            return max-min-2*k;
        }
        return 0;
    }
}
```