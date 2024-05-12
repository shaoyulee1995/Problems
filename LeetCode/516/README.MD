# Longest Palindromic Subsequence
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
# Dynamic Programming
* Time Complexity: O(NM)
* Space Complexity: O(N)
	* N is number of rows
	* M is number of cols

```
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = n - 2; i >= 0; i--){
            int prev = 0;
            for(int j = i+1; j < n; j++){
                int temp = dp[j];
                if(s.charAt(i) == s.charAt(j)){
                    dp[j] = prev + 2; 
                }else{
                    dp[j] = Math.max(dp[j], dp[j-1]);
                }
                prev = temp;
            }
        }
        return dp[n-1];
    }
}
```