# Unique Binary Search Trees

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
  - N as n

```java
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

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
  - N as n

```java
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

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N<sup>2</sup>)
  - N as n

```java
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

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
  - N as n

```java
class Solution {
    Map<Integer, Integer> map;
    public int numTrees(int n) {
        map = new HashMap();
        map.put(0,1);
        map.put(1,1);
        return dfs(n);
    }

    public int dfs(int n){
        if(map.get(n) != null){
            return map.get(n);
        }
        int val = 0;
        for(int i = 1; i <= n; i++){
            val += dfs(i-1) * dfs(n-i);
        }
        map.put(n, val);
        return val;
    }
}
```