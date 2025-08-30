#  Shortest Subarray With OR at Least K I

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int currentOR = 0;
            for(int j = i; j < nums.length; j++){
                currentOR |= nums[j];
                if(currentOR >= k){
                    res = Math.min(j-i+1, res);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE? -1: res;
    }
}
```