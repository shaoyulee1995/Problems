# Dynamic Programming
* Time Complexity: O(N<sup>2</sup>)
* Space Complexity: O(N)
```
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
```
# Recursion for N space
* Time Complexity: O(N<sup>2</sup>)
* Space Complexity: O(N)
	* N as n
```
class Solution {
    public int numTrees(int n) {
        int[] memo = new int[n+1];
        return numTrees(memo, n);
    }
    public int numTrees(int[] memo, int n){
        if(memo[n] != 0){
            return memo[n];
        }
        if(n <= 1){
            return 1;
        }
        int total = 0;
        for(int i = 1; i <= n; i++){
            total += numTrees(memo, i-1) * numTrees(memo, n-i);
        }
        memo[n] = total;
        return total;
    }
}
```
# Recursion for N^2 space
* Time Complexity: O(N^2)
* Space Complexity: O(N^2)
```
class Solution {
    int[][] memo;
    public int numTrees(int n) {
        memo = new int[n+1][n+1];
        return numTrees(1, n);
    }
    public int numTrees(int low, int high){
        if(low > high){
            return 1;
        }
        if(memo[low][high] != 0){
            return memo[low][high];
        }
        int res = 0;
        for(int mid = low; mid <= high; mid++){
            int left = numTrees(low, mid-1);
            int right = numTrees(mid+1, high);
            res += left*right;
        }
        memo[low][high] = res;
        return res;
    }
}
```