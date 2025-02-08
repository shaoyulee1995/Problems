# Find Nearest Point That Has the Same X or Y Coordinate

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as the length of the points array

```java
class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minDistance = Integer.MAX_VALUE,
            idx = -1;
        for(int i = 0; i < points.length; i++){
            int[] point = points[i];
            if(x == point[0] || y == point[1]){
                int currentDistance = Math.abs(x - point[0]) + Math.abs(y - point[1]);
                if(currentDistance < minDistance){
                    minDistance = currentDistance;
                    idx = i;
                }
            }
        }
        return idx;
    }
}
```
