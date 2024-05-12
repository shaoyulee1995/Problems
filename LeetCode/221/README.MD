# Maximal Square
# Matrix
* Time Complexity: O(NM)
* Space Complexity: O(NM)
	* N as length of matrix
	* M as length of matrix[0]
```
class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length,
            m = matrix[0].length,
            res = 0;
        int[][] grid = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0){
                    grid[i][j] = Character.getNumericValue(matrix[i][j]);
                    res = Math.max(res, grid[i][j]);
                    continue;
                }
                if(matrix[i][j] == '1'){
                    grid[i][j] = 1 + Math.min(grid[i-1][j-1],
                                        Math.min(grid[i][j-1],
                                                   grid[i-1][j]));
                    res = Math.max(res, grid[i][j]);
                }
            }
        }
        return res*res;
    }
}
```