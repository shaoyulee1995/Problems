# Missing Ranges

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as len of nums

```java
class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList();
        int next = lower;
        for(int num: nums){
            if(num < next){
                continue;
            }
            if(num == next){
                next++;
                continue;
            }
            res.add(Arrays.asList(next, num-1));
            next = num + 1;
        }
        if(next <= upper){
            res.add(Arrays.asList(next, upper));
        }
        return res;
    }
}
```
