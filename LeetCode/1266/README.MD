# Minimum Time Visiting All Points

- Time Complexity: O(P)
- Space Complexity: O(1)
  - N as length of points

```java
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        for(int i = 1; i < points.length; i++){
            int x = Math.abs(points[i][0] - points[i-1][0]),
                y = Math.abs(points[i][1] - points[i-1][1]);
            res += Math.max(x, y);
        }
        return res;
    }
}
```
