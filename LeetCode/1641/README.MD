# Count Sorted Vowel Strings

# 1D DP

- Time Complexity: O(N\*6)
- Space Complexity: O(N\*6)
  - N as n

```
class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n+1][6];
        for(int i = 1; i <= 5; i++){
            dp[0][i] = 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= 5; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[n][5];
    }
}
```

# 1D DP Optimize

```
class Solution {
    public int countVowelStrings(int n) {
        int[] dp = new int[]{0,1,1,1,1,1};
        for(int i = 1; i <= n; i++){
            for(int k = 1; k <= 5; k++){
                dp[k] += dp[k-1];
            }
        }
        return dp[5];
    }
}
```

# 2 Memorized DP

- Time Complexity: O(N\*5)
- Space Complexity: O(N\*5)
  - N as n

```
class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n+1][6];
        return countVowelStrings(n, 5, dp);
    }
    public int countVowelStrings(int n, int vowels, int[][] dp){
        if(n == 1){
            return vowels;
        }
        if(vowels == 1){
            return 1;
        }
        if(dp[n][vowels] != 0){
            return dp[n][vowels];
        }
        int cnt = countVowelStrings(n-1, vowels, dp) + countVowelStrings(n, vowels-1, dp);
        dp[n][vowels] = cnt;
        return cnt;
    }
}
```

- Time Complexity: O(5<sup>N</sup>)
- Space Complexity: O(N)
  - N as n

```
class Solution {
    char[] vowels = new char[]{'a','e','i','o','u'};
    public int countVowelStrings(int n) {
        int res = 0;
        for(char vowel: vowels){
            res += count(n-1, vowel);
        }
        return res;
    }
    public int count(int n, char last_char){
        if(n == 0){
            return 1;
        }
        int res = 0;
        for(char vowel: vowels){
            if(vowel >= last_char){
                res += count(n-1, vowel);
            }
        }
        return res;
    }
}
```
