# Find the Distinct Difference Array

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        HashMap<Integer, Integer> prefix = new HashMap(),
                                  suffix = new HashMap();
        int[] res = new int[nums.length];
        for(int num: nums){
            suffix.merge(num, 1, Integer::sum);
        }
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            prefix.merge(num, 1, Integer::sum);
            suffix.merge(num, -1, Integer::sum);
            if(suffix.get(num) == 0){
                suffix.remove(num);
            }
            res[i] = prefix.size() - suffix.size();
        }
        return res;
    }
}
```