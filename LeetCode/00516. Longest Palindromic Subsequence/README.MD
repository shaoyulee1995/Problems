# Dynamic Programming
* Time Complexity: O(NM)
* Space Complexity: O(NM)
	* N is number of rows
	* M is number of cols
```
class Solution {
    public int longestPalindromeSubseq(String s) {
        int m = s.length();
        int[][] dp = new int[m][m];
        for(int i = m - 1; i >= 0; i--){
            dp[i][i] = 1;
            for(int j = i + 1; j < m; j++){
                if(s.charAt(i) == (s.charAt(j))){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][m-1];
    }
}
```