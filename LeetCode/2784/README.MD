# Check if Array is Good

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public boolean isGood(int[] nums) {
        int[] cnt = new int[201];
        for(int num: nums){
            cnt[num]++;
        }
        for(int i = 1; i < nums.length-1; i++){
            if(cnt[i] != 1){
                return false;
            }
        }
        return cnt[nums.length-1] == 2;
    }
}
```
