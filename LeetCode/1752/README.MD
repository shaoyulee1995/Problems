# Check if Array Is Sorted and Rotated

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public boolean check(int[] nums) {
        int k = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > nums[(i+1)%nums.length]){
                k++;
            }
            if(k > 1){
                return false;
            }
        }
        return true;
    }
}
```
