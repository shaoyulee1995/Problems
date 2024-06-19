# Widest Vertical Area Between Two Points Containing No Points

# Arrays

- Time Complexity: O(Plog(P))
- Space Complexity: O(1)
  - P as length of points

```
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] -b[0]);
        int res = 0;
        for(int i = 1; i < points.length; i++){
            res = Math.max(res, points[i][0] - points[i-1][0]);
        }
        return res;
    }
}
```
