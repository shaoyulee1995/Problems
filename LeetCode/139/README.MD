# Word Break

# DP

- Time Complexity: O(NW)
- Space Complexity: O(N)
  - W as wordDict.size()
  - N as s.length()

```
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i = 0; i < n; i++){
            if(!dp[i]){
                continue;
            }
            for(String word: wordDict){
                int j = i + word.length();
                if(j <= n && s.substring(i, j).equals(word)){
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
```
