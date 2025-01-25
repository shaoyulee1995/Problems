# Word Break

- Time Complexity: O(NW)
- Space Complexity: O(N)
  - W as size of wordDict
  - N as length of s

```java
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[1+s.length()];
        dp[0] = true;
        for(int i = 0; i < s.length(); i++){
            if(!dp[i]){
                continue;
            }
            for(String word: wordDict){
                int j = i + word.length();
                if(j <= s.length() && s.substring(i, j).equals(word)){
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
```
