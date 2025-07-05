# Path with Maximum Gold

- Time Complexity: O((MN)<sup>2</sup>)
- Space Complexity: O(1)
    - M as length of grid
    - N as length of grid[0]

```java
class Solution {
    int totalGold;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int getMaximumGold(int[][] grid) {
        int res = 0;
        totalGold = Arrays.stream(grid).flatMapToInt(IntStream::of).filter(value -> value != 0).sum();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    continue;
                }
                res = Math.max(res, findMaxGold(grid, i, j, 0));
                if(res == totalGold){
                    return res;
                }
            }
        }
        return res;
    }
    public int findMaxGold(int[][] grid, int x, int y, int currentGold){
        int cell = grid[x][y],
            pathGold = 0;
        grid[x][y] = 0;
        currentGold += cell;
        for(int[] dir: dirs){
            int nextX = x + dir[0],
                nextY = y + dir[1];
            if(nextX < 0 || nextY < 0 || nextX == grid.length || nextY == grid[0].length || grid[nextX][nextY] == 0){
                continue;
            }
            if(currentGold + (totalGold - currentGold) > pathGold){
                pathGold = Math.max(pathGold, findMaxGold(grid, nextX, nextY, currentGold));
            }
        }
        grid[x][y] = cell;
        return pathGold + cell;
    }
}
```

- Time Complexity: O((MN)<sup>2</sup>)
- Space Complexity: O(1)
    - M as length of grid
    - N as length of grid[0]

```java
class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int getMaximumGold(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] != 0){
                    res = Math.max(res, findMaxGold(grid, i, j));
                }
            }
        }
        return res;
    }
    public int findMaxGold(int[][] grid, int x, int y){
        int cell = grid[x][y],
            pathGold = 0;
        grid[x][y] = 0;
        for(int[] dir: dirs){
            int nextX = x + dir[0],
                nextY = y + dir[1];
            if(nextX < 0 || nextY < 0 || nextX == grid.length || nextY == grid[0].length || grid[nextX][nextY] == 0){
                continue;
            }
            pathGold = Math.max(pathGold, findMaxGold(grid, nextX, nextY));
        }
        grid[x][y] = cell;
        return pathGold + cell;
    }
}
```