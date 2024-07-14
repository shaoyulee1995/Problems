# Difference Between Element Sum and Digit Sum of an Array

- Time Complexity: O(ND)
- Space Complexity: O(1)
  - N as length of nums
  - D as digits of num

```java
class Solution {
    public int differenceOfSum(int[] nums) {
        int min = 0,
            sum = 0;
        for(int num: nums){
            sum += num;
            int temp = num;
            while(temp > 0){
                min += temp%10;
                temp /= 10;
            }
        }
        return Math.abs(sum-min);
    }
}
```
