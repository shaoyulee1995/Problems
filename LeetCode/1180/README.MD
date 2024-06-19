# Count Substrings with Only One Distinct Letter

# String

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```
class Solution {
    public int countLetters(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                dp[i] = dp[i-1] + 1;
            }else{
                dp[i] = 1;
            }
        }
        return Arrays.stream(dp).sum();
    }
}
```

# String

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```
class Solution {
    public int countLetters(String s) {
        int total = 1,
            count = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
            }else{
                count = 1;
            }
            total += count;
        }
        return total;
    }
}
```
