# Maximum Average Subarray I

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length == 1 && k == 1){
            return nums[0];
        }
        int[] sum = nums.clone();
        for(int i = 1; i < nums.length; i++){
            if(i >= k){
                sum[i] -= nums[i-k];
            }
            sum[i] += sum[i-1];
        }
        double res = Integer.MIN_VALUE;
        for(int i = k-1; i < nums.length; i++){
            res = Math.max(res, sum[i]);
        }
        return res/k;
    }
}
```
