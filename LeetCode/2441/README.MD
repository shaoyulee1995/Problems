# Largest Positive Integer That Exists With Its Negative

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```
class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int num: nums){
            set.add(num);
        }
        int res = -1;
        for(int num: nums){
            if(num > 0 && set.contains(-num)){
                res = Math.max(num, res);
            }
        }
        return res;
    }
}
```
