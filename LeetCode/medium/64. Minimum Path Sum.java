class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                if(i==n-1 && j == m-1){
                    continue;
                }
                if(i == n-1){
                    grid[i][j] += grid[i][j+1];
                    continue;
                }
                if(j == m-1){
                    grid[i][j] += grid[i+1][j];
                    continue;
                }
                grid[i][j] += Math.min(grid[i][j+1], grid[i+1][j]);
            }
        }
        return grid[0][0];
    }
}