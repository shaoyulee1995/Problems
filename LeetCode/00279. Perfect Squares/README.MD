# DP 
* Time Complexity: O(Ns)
* Space Complexity: O(N)
	* N as n
	* s as square root of n
```
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int num = 1; num <= Math.sqrt(n); num++){
            for(int j = 0; j <= n; j++){
                if(j-num*num >= 0){
                    dp[j] = Math.min(dp[j], dp[j-num*num] + 1);
                }
            }
        }
        return dp[n];
    }
}
```
* Time Complexity: O(Ns)
* Space Complexity: O(N)
```
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; i++){
            dp[i] = i;
            for(int j = 1; i - j*j >= 0; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
```