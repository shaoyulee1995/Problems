# Minimum Falling Path Sum II

- Time Complexity: O(NM)
- Space Complexity: O(1)
  - N as length of grid
  - M as length of grid[0]

```java
class Solution {
    public int minFallingPathSum(int[][] grid) {
        for(int i = 1; i < grid.length; i++){
            int min1 = Integer.MAX_VALUE,
                min2 = Integer.MAX_VALUE;
            for(int j = 0; j < grid[0].length; j++){
                if(min1 > grid[i-1][j]){
                    min2 = min1;
                    min1 = grid[i-1][j];
                }else if(min2 > grid[i-1][j]){
                    min2 = grid[i-1][j];
                }
            }
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i-1][j] == min1){
                    grid[i][j] += min2;
                }else{
                    grid[i][j] += min1;
                }
            }
        }
        return Arrays.stream(grid[grid.length-1]).min().getAsInt();
    }
}
```
