# Increasing Triplet Subsequence

# Array

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min1 = Integer.MAX_VALUE,
            min2 = Integer.MAX_VALUE;
        for(int num: nums){
            if(num <= min1){
                min1 = num;
            }else if(num <= min2){
                min2 = num;
            }else{
                return true;
            }
        }
        return false;
    }
}
```
