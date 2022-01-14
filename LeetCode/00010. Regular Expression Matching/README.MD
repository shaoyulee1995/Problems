# DP
* Time Complexity: O(NM)
* Space Complexity: O(NM)
	* n = s.length()
	* m = p.length()
```
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(),
            m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        
        for(int i = 1; i <= n; i++){
            dp[i][0] = false;
        }
        
        for(int j = 1; j <= m; j++){
            dp[0][j] = false;
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-2];
            }
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-2];
                    if(p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1)){
                        dp[i][j] = (dp[i-1][j] || dp[i][j]);
                    }
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
}
```