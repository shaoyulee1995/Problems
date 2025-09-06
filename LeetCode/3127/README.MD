# Make a Square with the Same Color

- Time Complexity: O(1)
- Space Complexity: O(1)

```java
class Solution {
    public boolean canMakeSquare(char[][] grid) {
        return isSquare(grid, 0, 0) ||
               isSquare(grid, 1, 1) ||
               isSquare(grid, 1, 0) ||
               isSquare(grid, 0, 1);
    }

    private boolean isSquare(char[][] grid, int x, int y){
        int res = 0;
        res += grid[x][y] == grid[x+1][y]? 1: 0;
        res += grid[x][y] == grid[x][y+1]? 1: 0;
        res += grid[x][y] == grid[x+1][y+1]? 1: 0;
        return res != 1;
    }
}
```

- Time Complexity: O(1)
- Space Complexity: O(1)

```java
class Solution {
    public boolean canMakeSquare(char[][] grid) {
        int i = 0,
            j = 0;
        while(i < 2){
            while(j < 2){
                if(isSquare(grid, i, j)){
                    return true;
                }
                j++;
            }
            i++;
            j = 0;
        }
        return false;
    }

    private boolean isSquare(char[][] grid, int x, int y){
        int res = 0;
        res += grid[x][y] == grid[x+1][y]? 1: 0;
        res += grid[x][y] == grid[x][y+1]? 1: 0;
        res += grid[x][y] == grid[x+1][y+1]? 1: 0;
        return res != 1;
    }
}
```