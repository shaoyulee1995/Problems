# Minimum Sum of Four Digit Number After Splitting Digits

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as the number of digits in the number

```java
class Solution {
    public int minimumSum(int num) {
        char[] nums = (""+num).toCharArray();
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0, j = nums.length-1; i < j; i++, j--){
            res += Integer.parseInt(""+nums[i] + nums[j]);
        }
        return res;
    }
}
```
