# Minimum Cost to Make Array Equal

- Time Complexity: O(NlogJ)
- Space Complexity: O(1)  
  - N as the length of nums
  - J as the range of nums

```java
class Solution {
    public long minCost(int[] nums, int[] cost) {
        long i = 1L,
             j = (long)1e6,
             res = getCost(nums, cost, 1);
        while(i < j){
            long k = i + (j-i)/2,
                 y1 = getCost(nums, cost, k),
                 y2 = getCost(nums, cost, k+1);
            res = Math.min(res,
                  Math.min(y1, y2));
            if(y1 < y2){
                j = k;
            }else{
                i = k+1;
            }
        }
        return res;
    }

    private long getCost(int[] nums, int[] cost, long step){
        long res = 0;
        for(int i = 0; i < nums.length; i++){
            res += Math.abs(nums[i] - step) * cost[i];
        }
        return res;
    }
}
```