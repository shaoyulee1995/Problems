# Dynamic Programming
* Time Complexity: O(ST)
* Space Complexity: O(T)
	* S as length of stones
	* T as sum of stones/2
```
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int stone: stones){
            sum += stone;
        }
        int target = sum / 2;
        int[] dp =  new int[target+1];
        for(int stone: stones){
            for(int i = target ; i >= 0; i--){
                if(i - stone >= 0){
                    dp[i] = Math.max(dp[i], dp[i-stone] +stone);
                }
            }
        }
        return sum - 2 * dp[target];
    }
}
```