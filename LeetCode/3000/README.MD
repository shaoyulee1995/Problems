# Maximum Area of Longest Diagonal Rectangle

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of dimensions

```java
class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int res = 0;
        double maxDiagonal = 0;
        for(int[] dimension: dimensions){
            double currentDiagonal = Math.sqrt((double)Math.pow(dimension[0], 2) + (double)Math.pow(dimension[1], 2));
            if(currentDiagonal > maxDiagonal){
                maxDiagonal = currentDiagonal;
                res = dimension[0] * dimension[1];
            }else if(currentDiagonal == maxDiagonal){
                res = Math.max(res, dimension[0] * dimension[1]);
            }
        }
        return res;
    }
}
```
