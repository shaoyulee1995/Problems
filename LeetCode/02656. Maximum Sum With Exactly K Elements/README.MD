# Array
* Time Complexity: O(N)
* Space Complexity: O(1)
	* S as length of nums
```
class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt(),
            res = max;
        for(int i = 1; i < k; i++){
            res += max + i;
        }
        return res;
    }
}
```