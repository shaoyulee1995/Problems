# Integer Break

- Time Complexity: O(N^2)
- Space Complexity: O(N)
  - N as n

```
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for(int i = 3; i <= n; i++){
            for(int j = 1; j < i - 1; j++){
                dp[i] = Math.max(dp[i], j*Math.max((i-j), dp[i-j]));
            }
        }
        return dp[n];
    }
}
```

# Memorization DFS

- Time Complexity: O(N^2)
- Space Complexity: O(N)
  - N as n

```
class Solution {
    HashMap<Integer, Integer> map;
    public int integerBreak(int n) {
        if(n == 2 || n == 3){
            return n-1;
        }
        map = new HashMap();
        map.put(1,1);
        return dfs(n);
    }
    public int dfs(int num){
        if(num == 0){
            return 1;
        }
        if(map.get(num) != null){
            return map.get(num);
        }
        int val = Integer.MIN_VALUE;
        for(int i = 1; i <= num; i++){
            int temp = i * dfs(num-i);
            val = Math.max(temp, val);
        }
        map.put(num, val);
        return val;
    }
}
```
