# Find the Array Concatenation Value

# Array

- Time Complexity: O(Nn)
- Space Complexity: O(1)
  - N as length of nums
    - n as max length of num

```
class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long res = 0;
        int i = 0,
            j = nums.length-1;
        for(; i < j; i++, j--){
            int len = getLength(nums[j]);
            res += (long)Math.pow(10, len) * nums[i] + nums[j];
        }
        if(i == j){
            res += nums[i];
        }
        return res;
    }
    public int getLength(int num){
        int len = 0;
        while(num != 0){
            len++;
            num /= 10;
        }
        return len;
    }
}
```
