# Find the Middle Index in Array

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int findMiddleIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for(int i = 0; i < nums.length; i++){
            if(sum - nums[i] == 2 * leftSum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
```
