# Spiral Matrix II

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N<sup>2</sup>)
  - N as n

```java
class Solution {
    public int[][] generateMatrix(int n) {
        int startRow = 0,
            startCol = 0,
            endRow = n-1,
            endCol = n-1,
            val = 1;
        int[][] grid = new int[n][n];
        while(val <= n*n){
            for(int i = startCol; i <= endCol; i++){
                grid[startRow][i] = val++;
            }
            startRow++;
            for(int i = startRow; i <= endRow; i++){
                grid[i][endCol] = val++;
            }
            endCol--;
            for(int i = endCol; i >= startCol; i--){
                grid[endRow][i] = val++;
            }
            endRow--;
            for(int i = endRow; i >= startRow; i--){
                grid[i][startCol] = val++;
            }
            startCol++;
        }
        return grid;
    }
}
```
