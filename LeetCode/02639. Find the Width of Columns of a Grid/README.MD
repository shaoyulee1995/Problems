# Matrix
* Time Complexity: O(NM)
* Space Complexity: O(1)
    * N as length of grid
    * M as length of grid[0]
```
class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int[] res = new int[grid[0].length];
        for(int j = 0; j < grid[0].length; j++){
            for(int i = 0; i < grid.length; i++){
                res[j] = Math.max(res[j], String.valueOf(grid[i][j]).length());
            }
        }  
        return res;  
    }
}
```