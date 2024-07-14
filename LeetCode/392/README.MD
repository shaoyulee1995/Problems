# Is Subsequence

- Time Complexity: O(S)
- Space Complexity: O(1)
  - S as length of s

```java
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0,
            j = 0;
        while(i < s.length() && j < t.length()){
            char a = s.charAt(i),
                 b = t.charAt(j);
            if(a == b){
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
```

- Time Complexity: O(ST)
- Space Complexity: O(ST)
  - S as length of s
  - T as length of t

```java
class Solution {
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < t.length(); j++){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + 1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[s.length()][t.length()] == s.length();
    }
}
```
