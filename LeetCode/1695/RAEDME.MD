# Maximum Erasure Value

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> seen = new HashSet();
        int res = 0;
        for(int i = 0, j = 0, sum = 0; j < nums.length;){
            if(seen.add(nums[j])){
                sum += nums[j];
                j++;
                res = Math.max(res, sum);
            }else{
                sum -= nums[i];
                seen.remove(nums[i]);
                i++;
            }
        }
        return res;
    }
}
```