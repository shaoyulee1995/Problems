# Dynamic Programming
* Time Complexity: O(N*M)
* Space Complexity: O(N*M)
	* N is the length of text1
	* M is the length of text2
```
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(),
            m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
```

# Memorized Recursion
* Time Complexity: O(N*M)
* Space Complexity: O(N*M)
	* N is the length of text1
	* M is the length of text2
```
class Solution {
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for(int[] row: memo){
            Arrays.fill(row, -1);
        }
        return longestCommonSubsequence(text1, 0, text2, 0);
    }
    public int longestCommonSubsequence(String text1, int p1, String text2, int p2){
        if(p1 == text1.length() || p2 == text2.length()){
            return 0;
        }
        if(memo[p1][p2] != -1){
            return memo[p1][p2];
        }
        if(text1.charAt(p1) == text2.charAt(p2)){
            memo[p1][p2] = 1 + longestCommonSubsequence(text1, p1 + 1, text2, p2 + 1);
        }else{
            memo[p1][p2] = Math.max(longestCommonSubsequence(text1, p1 + 1, text2, p2 + 1),
                           Math.max(longestCommonSubsequence(text1, p1, text2, p2 + 1),
                                    longestCommonSubsequence(text1, p1 + 1, text2, p2 )));
        }
        return memo[p1][p2];
    }
}
```