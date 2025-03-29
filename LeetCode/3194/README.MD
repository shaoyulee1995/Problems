# Minimum Average of Smallest and Largest Elements

- Time Complexity: O(NlogN)
- Space Complexity: O(1)
  - P as length of path

```java
class Solution {
    public double minimumAverage(int[] nums) {
        double res = Double.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0, j = nums.length-1;i < j; i++, j--){
            double avg = (double)(nums[i] + nums[j])/2;
            res = Math.min(res, avg);
        }
        return res;
    }
}
```