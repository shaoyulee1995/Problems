# Maximum Average Subarray I

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0d;
        }
        if (nums.length == 1 && k == 1) {
            return nums[0];
        }
        int[] sum = nums.clone();
        for (int i = 1; i < nums.length; i++) {
            if (i - k >= 0) {
                sum[i] -= nums[i - k];
            }
            sum[i] += sum[i - 1];
        }

        double res = -Double.MAX_VALUE;
        for (int i = k - 1; i < nums.length; i++) {
            res = Math.max(res, sum[i]);
        }
        return res / k;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        long sum = 0l;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        long res = sum;
        for(int i = k; i < nums.length; i++){
            sum += nums[i] - nums[i-k];
            res = Math.max(res, sum);
        }
        return res/1d/k;
    }
}
```