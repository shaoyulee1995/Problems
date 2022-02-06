# Recursion
* Time Complexity: O(DT)
* Space Complexity: O(DT)
	* D as d
	* T as target
```
class Solution {
    final int mod = (int)1e9+7;
    HashMap<String, Integer> map = new HashMap();
    public int numRollsToTarget(int d, int f, int target) {
        if(target>d*f || target < d){
            return 0;
        }
        if(d==1){
            return target<=f?1:0;
        }
        final String key = "" + d + f + target;
        if(!map.containsKey(key)){
            int curSum = 0;
            for(int i = 1; i <= f; i++){
                curSum += numRollsToTarget(d-1, f, target-i);
                curSum %= mod;
            }
            map.put(key, curSum);
        }
        return map.get(key); 
    }
}
```
# KnapSack
* Time Complexity: O(NTK)
* Space Complexity: O(NT)
	* N as n
	* T as target
	* K as k
```
class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= target; j++){
                for(int f = 1; f <= k && j >= f; f++){
                    dp[i][j] += dp[i-1][j-f];
                }
            }
        }
        return dp[n][target];
    }
}
```