# Get Maximum in Generated Array

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as the length of the array

```java
class Solution {
    public int getMaximumGenerated(int n) {
        if(n == 0){
            return 0;
        }
        int[] nums = new int[n+1];
        nums[1] = 1;
        int res = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            if(i*2 <= n){
                nums[i*2] = nums[i];
            }
            if(i*2+1 <= n){
                nums[i*2+1] = nums[i] + nums[i+1];
            }
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as the length of the array

```java
class Solution {
    public int getMaximumGenerated(int n) {
        if(n == 0){
            return 0;
        }
        int[] nums = new int[n+1];
        int res = 0;
        nums[1] = 1;
        for(int i = 0; i <= n/2; i++){
            nums[i*2] = nums[i];
            if(i*2+1 <= n){
                nums[i*2+1] = nums[i] + nums[i+1];
                res = Math.max(res, nums[i*2+1]);
            }
        }
        return res;
    }
}
```
