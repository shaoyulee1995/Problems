# Find Numbers with Even Number of Digits

- Time Complexity: O(NlogM)
- Space Complexity: O(1)
  - N as length of nums
  - M as largest value in nums

```java
class Solution {
    public int findNumbers(int[] nums) {
        int res = 0;
        for(int num: nums){
            int cnt = 0;
            while(num != 0){
                cnt++;
                num /= 10;
            }
            res += (cnt%2==0)? 1: 0;
        }
        return res;
    }
}
```
