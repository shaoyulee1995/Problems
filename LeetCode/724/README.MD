# Find Pivot Index

# Array

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```
class Solution {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum(),
            prevSum = 0;
        for(int i = 0; i < nums.length; i++){
            if(prevSum == sum - prevSum - nums[i]){
                return i;
            }
            prevSum += nums[i];
        }
        return -1;
    }
}
```
