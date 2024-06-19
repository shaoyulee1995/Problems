# Teemo Attacking

# Array

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of timeSeries

```
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0,
            start = timeSeries[0],
            end = start + duration;
        for(int i = 1; i < timeSeries.length; i++){
            if(timeSeries[i] > end){
                res += end - start;
                start = timeSeries[i];
            }
            end = timeSeries[i] + duration;
        }
        res += end - start;
        return res;
    }
}
```
