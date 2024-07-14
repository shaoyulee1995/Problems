# Sum of Digits in the Minimum Number

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int sumOfDigits(int[] nums) {
        int min =  Arrays.stream(nums).min().getAsInt();
        int sum = 0;
        while(min != 0){
            sum += min%10;
            min /= 10;
        }
        return 1 - sum%2;
    }
}
```
