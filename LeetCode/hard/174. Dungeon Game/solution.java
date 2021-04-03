class Solution {
    public int calculateMinimumHP(int[][] grid) {
        int m = grid.length,  n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        
        for(int i = 0; i < m+1; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m][n-1] = 1;
        dp[m-1][n] = 1;
        
        for(int i = m-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
                int minHP = Math.min(dp[i+1][j], dp[i][j+1]) - grid[i][j];
                if(minHP < 1){
                    dp[i][j] = 1;   
                }else{
                    dp[i][j] = minHP;
                }
            }
        }
        return dp[0][0];
    }
}