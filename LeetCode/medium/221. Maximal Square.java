class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = Character.getNumericValue(matrix[i][j]);
                    max = Math.max(max, dp[i][j]);
                    continue;
                }
                if(matrix[i][j] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1],
                                       Math.min(dp[i][j-1], dp[i-1][j]));
                    max = Math.max(max, dp[i][j]);
                }
                
            }
        }
        return max * max;
    }
}