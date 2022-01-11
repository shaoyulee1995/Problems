# Memorization Recursion
* Time Complexity: O(NM)
* Space Complexity: O(NM)
```
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length,
            m = dungeon[0].length;
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[n][m-1] = 1;
        dp[n-1][m] = 1;
        for(int i = n-1; i>=0; i--){
            for(int j = m-1; j >= 0; j--){
                int minHp = Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j];
                if(minHp < 1){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = minHp;
                }
            }
        }
        return dp[0][0];
    }
}
```