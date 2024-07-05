# Delete Operation for Two Strings

- Time Complexity: O(N\*M)
- Space Complexity: O(N\*M)
  - N is the length of word1
  - M is the length of word2

```
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(),
            m = word2.length(),
            lcs = longestCommonSubsequence(word1, word2);
        return n - lcs + m - lcs;
    }

    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
```
