# Dynamic Programming
* Time Complexity: O(NM)
* Space Complexity: O(NM)
	* N is number of rows
	* M is number of cols
```
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix[0].length; i++){
            dp[0][i] = matrix[0][i];`
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(j == 0){
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1]);
                }else if(j == matrix[0].length - 1){
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]);
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]);
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j+1]);
                }
                dp[i][j] += matrix[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for(int num: dp[matrix.length - 1]){
            res = Math.min(res, num);
        }
        return res;
    }
}
```