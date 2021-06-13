class Solution {
    public int numRollsToTarget(int dices, int faces, int target) {
        int[][] dp = new int[dices+1][target+1];
        int mod = (int)1e9+7;
        dp[0][0] = 1;
        for(int dice = 1; dice <= dices; dice++){
            for(int t = 0; t <= target; t++){
                for(int face = 1; face <= faces; face++){
                    if(t<face){
                        continue;
                    }
                    dp[dice][t] = (dp[dice][t] + dp[dice-1][t-face])%mod;
                }
            }
        }
        return dp[dices][target];
    }
}