# Dynamic Programming
* Time Complexity: O(ST)
* Space Complexity: O(30*100)
	* S as length of stones
	* T as sum of stones/2
```
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int[] dp = new int[30*100+1];
        int sum = 0;
        for(int stone: stones){
            sum += stone;
        }
        int target = sum / 2;
        for(int stone: stones){
            for(int i = target; i >= stone; i--){
                dp[i] = Math.max(dp[i], dp[i-stone] + stone);
            }
        }
        return sum - dp[target] - dp[target];
    }
}
```