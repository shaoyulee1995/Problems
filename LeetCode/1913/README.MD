# Maximum Product Difference Between Two Pairs

- Time Complexity: O(NlogN)
- Space Complexity: O(1)
  - N as length of nums

```
class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return (nums[n-1] * nums[n-2]) - (nums[0] * nums[1]);
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```
class Solution {
    public int maxProductDifference(int[] nums) {
        if(nums.length < 4){
            return 0;
        }
        int max1 = Integer.MIN_VALUE,
            max2 = Integer.MIN_VALUE,
            min1 = Integer.MAX_VALUE,
            min2 = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max1 || nums[i] > max2){
                max2 = Math.max(max2, max1);
                max1 = nums[i];
            }
            if(nums[i] < min1 || nums[i] < min2){
                min2 = Math.min(min2, min1);
                min1 = nums[i];
            }
        }
        return (max2*max1) - (min2*min1);
    }
}
```
