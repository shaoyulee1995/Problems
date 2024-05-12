# Minimum Value to Get Positive Step by Step Sum
# Array
* Time Complexity: O(N)
* Space Complexity: O(1)
    * N as length of nums
```
class Solution {
    public int minStartValue(int[] nums) {
        int total = 0,
            min = 0;
        for(int num: nums){
            total += num;
            min = Math.min(min, total);
        }
        return -min+1;
    }
}
```