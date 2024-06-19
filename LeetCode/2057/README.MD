# Smallest Index With Equal Value

# Array

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```
class Solution {
    public int smallestEqual(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(i%10 == nums[i]){
                return i;
            }
        }
        return -1;
    }
}
```
