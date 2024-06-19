# Decode Ways

# DP

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```
class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = (s.charAt(0) == '0')? 0: 1;
        for(int i = 2; i <= s.length(); i++){
            int ones = Integer.parseInt(s.substring(i-1, i)),
                tens = Integer.parseInt(s.substring(i-2, i));
            if(ones <= 9 && ones >= 1){
                dp[i] += dp[i-1];
            }
            if(tens <= 26 && tens >= 10){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
```
