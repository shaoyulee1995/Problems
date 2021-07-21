# Dynamic Programming
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public int numTrees(int n) {
        if(n < 1){
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
    }
}
```

# Recursion with Memorization
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