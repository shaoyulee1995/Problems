# Count Servers that Communicate

- Time Complexity: O(MN)
- Space Complexity: O(MN)

```
class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length,
            n = grid[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 1){
                    continue;
                }
                rowCount[i]++;
                colCount[j]++;
            }
        }
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0 ; j < n; j++){
                if(grid[i][j] != 1){
                    continue;
                }
                if(rowCount[i] > 1 || colCount[j] > 1){
                    res++;
                }
            }
        }
        return res;
    }
}
```
