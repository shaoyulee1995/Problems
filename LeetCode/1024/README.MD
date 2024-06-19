# Video Stitching

# Greedy

- Time Complexity: O(TC)
- Space Complexity: O(1)
  - T as time
  - C as length of clips

```
class Solution {
    public int videoStitching(int[][] clips, int time) {
        int clip = 0,
            start = 0,
            end = 0;
        while(start < time){
            for(int[] c: clips){
                if(start >= c[0]){
                    end = Math.max(end, c[1]);
                }
            }
            if(start == end){
                return -1;
            }
            clip++;
            start = end;
        }
        return clip;
    }
}
```
