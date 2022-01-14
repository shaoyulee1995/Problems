# DP
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public int candy(int[] ratings) {
        int[] dp = new int[ratings.length];
        Arrays.fill(dp, 1);
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i-1] < ratings[i]){
                dp[i] = dp[i-1] + 1;
            }
        }
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                dp[i] = Math.max(dp[i+1] + 1, dp[i]);
            }
        }
        int res = 0;
        for(int i = 0; i < ratings.length; i++){
            res += dp[i];
        }
        return res;
    }
}
```