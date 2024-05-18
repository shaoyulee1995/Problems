# 3Sum Closest

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i + 2 < nums.length; i++){
            int j = i+1,
                k = nums.length-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    return target;
                }
                if(sum - target < Math.abs(diff)){
                    diff = target - sum;
                }
                if(sum < target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return target - diff;
    }
}
```
