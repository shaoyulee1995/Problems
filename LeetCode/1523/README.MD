# Count Odd Numbers in an Interval Range

- Time Complexity: O(1)
- Space Complexity: O(1)

```
class Solution {
    public int countOdds(int low, int high) {
        if((low&1) == 0){
            low++;
        }
        return low>high? 0: (high-low)/2+1;
    }
}
```
