# Find Closest Number to Zero

# Arrah

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int findClosestNumber(int[] nums) {
        int res = Integer.MAX_VALUE;
        for(int num: nums){
            if(Math.abs(num) < Math.abs(res) || num == Math.abs(res)){
                res = num;
            }
        }
        return res;
    }
}
```
