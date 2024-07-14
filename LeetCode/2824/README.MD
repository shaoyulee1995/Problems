# Count Pairs Whose Sum is Less than Target

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(1)
  - N as length nums

```java
class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int res = 0;
        for(int i = 0; i+1 < nums.size(); i++){
            for(int j = i+1; j < nums.size(); j++){
                if(nums.get(i) + nums.get(j) < target){
                    res++;
                }
            }
        }
        return res;
    }
}
```
