# Minimum Number of Arrows to Burst Balloons

- Time Complexity: O(PlogP)
- Space Complexity: O(1)
  - P as length of points

```java
class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int res = 1,
            burstPosition = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(points[i][0] <= burstPosition){
                continue;
            }
            burstPosition = points[i][1];
            res++;
        }
        return res;
    }
}
```

- Time Complexity: O(PlogP)
- Space Complexity: O(1)
  - P as length of points

```java
class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int res = 0,
            burstPosition = Integer.MIN_VALUE;
        boolean flag = false;
        for(int[] p: points){
            int a = p[0],
                b = p[1];
            if(a <= burstPosition && flag == true){
                continue;
            }
            burstPosition = b;
            flag = true;
            res++;
        }
        return res;
    }
}
```
