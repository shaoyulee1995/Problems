# Degree of an Array

# HashMap

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```
class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap(),
                                  firstOccurance = new HashMap();
        int maxDegree = 0,
            res = 0;
        for(int i = 0; i < nums.length; i++){
            firstOccurance.putIfAbsent(nums[i], i);
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            if(freq.get(nums[i]) > maxDegree){
                maxDegree = freq.get(nums[i]);
                res = i - firstOccurance.get(nums[i]);
            }else if(freq.get(nums[i]) == maxDegree){
                res = Math.min(res, i - firstOccurance.get(nums[i]));
            }
        }
        return res + 1;
    }
}
```
