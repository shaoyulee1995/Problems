# Ones and Zeroes

# Recursion Memorized

- Time Complexity: O(SMN)
- Space Complexity: O(SMN)
  - S is length of strs
  - M is m
  - N is n

```
class Solution {
    int[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new int[strs.length][m+1][n+1];
        return findMaxForm(strs, m, n, 0);
    }
    public int findMaxForm(String[] strs, int m, int n, int index){
        if(index == strs.length || m + n == 0){
            return 0;
        }
        if(dp[index][m][n] != 0){
            return dp[index][m][n];
        }
        int zeros = 0,
            ones = 0;
        for(char c: strs[index].toCharArray()){
            if(c == '0'){
                zeros++;
            }else{
                ones++;
            }
        }
        int consider = 0;
        if(m >= zeros && n >= ones){
            consider = findMaxForm(strs, m-zeros, n-ones, index+1)+1;
        }
        int skip = findMaxForm(strs, m, n, index+1);
        dp[index][m][n] = Math.max(consider, skip);
        return dp[index][m][n];
    }
}
```

# DP (Knapsack)

- Time Complexity: O(SMN)
- Space Complexity: O(MN)
  - S is length of strs
  - M is m
  - N is n

```
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(String s: strs){
            int ones = 0,
                zeros = 0;
            for(char c: s.toCharArray()){
                if(c == '0'){
                    zeros++;
                }else{
                    ones++;
                }
            }
            for(int zero = m; zero >= zeros; zero--){
                for(int one = n; one >= ones; one--){
                    dp[zero][one] = Math.max(dp[zero][one], 1+dp[zero-zeros][one-ones]);
                }
            }
        }
        return dp[m][n];
    }
}
```
