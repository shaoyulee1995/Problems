# Valid Boomerang

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public boolean isBoomerang(int[][] points) {
        if(points.length < 3){
            return false;
        }
        int x1 = points[0][0],
            y1 = points[0][1],
            x2 = points[1][0],
            y2 = points[1][1];
        for(int i = 2; i < points.length; i++){
            int[] point = points[i];
            int x3 = point[0],
                y3 = point[1];

            if((y1-y2)*(x3-x2) == (y3-y2)*(x1-x2)){
                return false;
            }
        }
        return true;
    }
}
```
