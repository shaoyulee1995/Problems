# 2899. Last Visited Integers

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public List<Integer> lastVisitedIntegers(int[] nums) {
        List<Integer> res = new ArrayList(),
                      seen = new ArrayList();
        for(int i = 0, prevCounts = 0; i < nums.length; i++){
            if(nums[i] == -1){
                prevCounts++;
                if(prevCounts <= s een.size()){
                    res.add(seen.get(seen.size()-prevCounts));
                }else{
                    res.add(-1);
                }
            }else{
                seen.add(nums[i]);
                prevCounts = 0;
            }
        }
        return res;
    }
}
```