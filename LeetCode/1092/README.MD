# Shortest Common Supersequence

# LCS

- Time Complexity: O(NM)
- Space Complexity: O(NM)
  - N as length of str1
    - M as length of str2

```
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        lcs(str1, str2, dp);
        int i = str1.length()-1,
            j = str2.length()-1;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 && j >= 0){
            if(str1.charAt(i) == str2.charAt(j)){
                sb.append(str1.charAt(i));
                i--;
                j--;
            }else{
                if(dp[i+1][j] > dp[i][j+1]){
                    sb.append(str2.charAt(j--));
                }else{
                    sb.append(str1.charAt(i--));
                }
            }
        }
        while(i >= 0){
            sb.append(str1.charAt(i--));
        }
        while(j >= 0){
            sb.append(str2.charAt(j--));
        }
        return sb.reverse().toString();
    }

    public void lcs(String str1, String str2, int[][] dp){
        for(int i = 0; i < str1.length(); i++){
            for(int j = 0; j < str2.length(); j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + 1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
    }
}
```
