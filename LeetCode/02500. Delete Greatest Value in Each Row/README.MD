# Matrix
* Time Complexity: O(NMlogM)
* Space Complexity: O(1)
    * N as length of grid
    * M as length of grid[0]
```
class Solution {
    public int deleteGreatestValue(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            Arrays.sort(grid[i]);
        }
        int res = 0;
        for(int j = 0; j < grid[0].length; j++){
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < grid.length; i++){
                max = Math.max(grid[i][j], max);
            }
            res += max;
        }
        return res;
    }
}
```