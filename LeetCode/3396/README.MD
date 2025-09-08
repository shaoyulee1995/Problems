# Minimum Number of Operations to Make Elements in Array Distinct

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int minimumOperations(int[] nums) {
        int[] cnt = new int[101];
        for(int i = nums.length-1; i >= 0; i--){
            if(++cnt[nums[i]] > 1){
                return (i+3)/3;
            }
        }
        return 0;
    }
}
```