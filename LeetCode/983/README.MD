# Minimum Cost For Tickets
# DP
* Time Complexity: O(D)
* Space Complexity: O(366)
	* D as lastDay
```
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        int lastDay = days[days.length-1];
        int j = 0;
        for(int i = 1; i <= lastDay; i++){
            if(i != days[j]){
                dp[i] = dp[i-1];
            }else{
                dp[i] = dp[i-1] + costs[0];
                dp[i] = Math.min(dp[i], dp[Math.max(0, i-7)] + costs[1]);
                dp[i] = Math.min(dp[i], dp[Math.max(0, i-30)] + costs[2]);
                j++;
            }
        }
        return dp[lastDay];
    }
}
```