# Math
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of nums
```
class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int num: nums){
            min = Math.min(min, num);
        }
        int res = 0;
        for(int num: nums){
            res += num-min;
        }
        return res;
    }
}
```