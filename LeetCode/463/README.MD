# Island Perimeter

# Matrix

- Time Complexity: O(NM)
- Space Complexity: O(1)
  - N as length of grid
    - M as length of grid[0]

```
class Solution {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
          for(int j = 0; j < grid[0].length; j++){
            if(grid[i][j] == 1){
              res += 4;
              if(j > 0 && grid[i][j-1] == 1){
                res -= 2;
              }
              if(i > 0 && grid[i-1][j] == 1){
                res -= 2;
              }
            }
          }
        }
        return res;
    }
}
```
