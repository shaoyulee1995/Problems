# Decode Ways

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = (s.charAt(0) == '0')? 0: 1;
        for(int i = 2; i <= s.length(); i++){
            int ones = Integer.parseInt(s.substring(i-1, i)),
                tens = Integer.parseInt(s.substring(i-2, i));
            if(between(1, 9, ones)){
                dp[i] += dp[i-1];
            }
            if(between(10, 26, tens)){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }

    private boolean between(int start, int end, int val){
        return val >= start && val <= end;
    }
}
```
