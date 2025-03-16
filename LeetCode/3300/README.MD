# Minimum Elements After Replacement With Digit Sum

- Time Complexity: O(NlogM)
- Space Complexity: O(1)
  - N as the length of the array
  - M as the maximum number in the array
   
```java
class Solution {
    public int minElement(int[] nums) {
        int res = Integer.MAX_VALUE;
        for(int num: nums){
            res = Math.min(res, getSum(num));
        }
        return res;
    }
    public int getSum(int num){
        int res = 0;
        while(num != 0){
            res += num%10;
            num /= 10;
        }
        return res;
    }
}
```