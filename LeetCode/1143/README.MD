# Longest Common Subsequence

- Time Complexity: O(NM)
- Space Complexity: O(NM)
  - N is the length of text1
  - M is the length of text2

```java
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i = 0; i < text1.length(); i++){
            for(int j = 0; j < text2.length(); j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + 1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
```

# Memorized Recursion

- Time Complexity: O(NM)
- Space Complexity: O(NM)
  - N is the length of text1
  - M is the length of text2

```
class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];
        for(int i = 0; i < text1.length(); i++){
            Arrays.fill(dp[i], -1);
        }
        return dfs(text1, 0, text2, 0);
    }

    public int dfs(String a, int i, String b, int j){
        if(i == a.length() || j == b.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(a.charAt(i) == b.charAt(j)){
            dp[i][j] = 1 + dfs(a, i+1, b, j+1);
        }else{
            dp[i][j] = Math.max(dfs(a, i, b, j+1),
                                dfs(a, i+1, b, j));
        }
        return dp[i][j];
    }
}
```
