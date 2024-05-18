# Find Subarrays With Equal Sum

- Time Complexity: O(N)
- Space Complexity: O(N)
  - n as length of nums

```java
class Solution {
    public boolean findSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for(int i = 1; i < nums.length; i++){
            if(!set.add(nums[i] + nums[i-1])){
                return true;
            }
        }
        return false;
    }
}
```
