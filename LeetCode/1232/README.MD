# Check If It Is a Straight Line

# Math

- Time Complexity: O(N)
- Space Complexity: O(1)

```
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int[] point1 = coordinates[0],
              point2 = coordinates[1];
        int x1 = point1[0],
            x2 = point2[0],
            y1 = point1[1],
            y2 = point2[1];
        //(y2 - y1)(x3 - x1) == (x2 - x1)(y3 - y1)

        for(int i = 2; i < coordinates.length; i++){
            int[] point3 = coordinates[i];

            int x3 = point3[0],
                y3 = point3[1];
            if((y2 - y1)*(x3 - x1) != (x2 - x1)*(y3 - y1)){
                return false;
            }
        }
        return true;
    }
}
```
