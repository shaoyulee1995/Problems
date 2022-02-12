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