# String
* Time Complexity: O(N!)
* Space Complexity: O(N<sup>2</sup>)
	* N as n
```
class Solution {
    public int totalNQueens(int n) {
        char[][] grid = new char[n][n];
        for(char[] row: grid){
            Arrays.fill(row, '.');
        }
        return dfs(grid, 0);
    }

    public int dfs(char[][] grid, int row){
        if(row == grid.length){
            return 1;
        }
        int count = 0;
        for(int col = 0; col < grid[0].length; col++){
            if(valid(grid, row, col)){
                grid[row][col] = 'Q';
                count += dfs(grid, row+1);
                grid[row][col] = '.';
            }
        }
        return count;
    }

    public boolean valid(char[][] grid, int r, int c){
        for(int i = 0; i < grid.length; i++){
            if(grid[i][c] == 'Q'){
                return false;
            }
        }

        for(int i = r-1, j = c-1; i >= 0 && j >= 0; i--, j--){
            if(grid[i][j] == 'Q'){
                return false;
            }
        }
        for(int i = r-1, j = c+1; i >= 0 && j < grid[0].length; i--, j++){
            if(grid[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
```