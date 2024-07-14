# Find Target Indices After Sorting Array

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res = new ArrayList();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                res.add(i);
            }
        }
        return res;
    }
}
```
