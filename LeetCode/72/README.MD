# Edit Distance
# DP
* Time Complexity: O(NM)
* Space Complexity: O(NM)
	* N is length of word1
	* M is length of word2
```
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(),
            m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = i;
        }
        for(int i = 0; i <= m; i++){
            dp[0][i] = i;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];    
                }else{
                    dp[i][j] = 1 + min(dp[i-1][j],
                                       dp[i-1][j-1],
                                       dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    
    public int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}
```
# Memorized Recursion
* Time Complexity: O(NM)
* Space Complexity: O(NM)
	* N is length of word1
	* M is length of word2
```
class Solution {
    Integer[][] dp;
    public int minDistance(String word1, String word2) {
        dp = new Integer[word1.length()+1][word2.length()+1];
        return traverse(word1, word2, word1.length(), word2.length());
    }

    public int traverse(String word1, String word2, int i, int j){
        if(i == 0){
            return j;
        }
        if(j == 0){
            return i;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        int min = 0;
        if(word1.charAt(i-1) == word2.charAt(j-1)){
            return traverse(word1, word2, i-1, j-1);
        }else{
            int insert = traverse(word1, word2, i, j-1),
                delete = traverse(word1, word2, i-1, j),
                replace = traverse(word1, word2, i-1, j-1);
            min = Math.min(insert, Math.min(delete, replace))+1;
        }
        dp[i][j] = min;
        return dp[i][j];
    }
}
```