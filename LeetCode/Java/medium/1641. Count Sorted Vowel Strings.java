class Solution {
    public int countVowelStrings(int n) {
        int[] dp = new int[]{0,1,1,1,1,1};
        
        for(int i = 1; i <= n; i++){
            for(int k = 1; k <= 5; k++){
                dp[k] += dp[k-1];
            }
        }
        /*
                     x u o i e  a
        initialize   0 1 1 1 1  1
        n = 1        0 1 2 3 4  5
        n = 2        0 1 3 6 10 15
        and so on
        */
        return dp[5];
    }
}