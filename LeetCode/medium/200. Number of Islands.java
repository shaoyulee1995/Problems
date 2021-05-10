class Solution {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    cnt++;
                    checkSize(grid, i, j);
                }
            }
        }
        return cnt;
    }
    private void checkSize(char[][] grid, int i, int j){
        if(i < 0 || i == grid.length){
            return;
        }
        if(j < 0 || j == grid[i].length){
            return;
        }
        if(grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        checkSize(grid, i-1, j);
        checkSize(grid, i+1, j);
        checkSize(grid, i, j+1);
        checkSize(grid, i, j-1);
    }
}