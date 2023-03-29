# Dynamic Programming
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as n
## Java
```
class Solution {
    public int fib(int n) {
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
```
* Time Complexity: O(N)
* Space Complexity: O(2)
	* N as n
```
class Solution {
    public int fib(int n) {
        if(n < 1){
            return 0;
        }
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }
}
```
## C++
```
class Solution {
public:
    int fib(int n) {
        if(n < 1){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        vector<int> dp(n+1, 0);
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
};
```

# Recursion with Memorization
* Time Complexity: O(N)
* Space Complexity: O(N)
## Java
```
class Solution {
    public int fib(int n) {
        return fib(new HashMap<Integer, Integer>(), n);
    }
    public int fib(HashMap<Integer, Integer> map, int n){
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        int val = fib(map, n-1) + fib(map, n-2);
        map.put(n, val);
        return val;
    }
}
```
## C++
```
class Solution {
public:
    int fib(int n) {
        if(n < 1){
            return 0;
        }
        vector<int> memo(n+1, 0);
        return fib(memo, n);
    }
    int fib(vector<int> &memo, int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(memo[n] != 0){
            return memo[n];
        }
        memo[n] = fib(memo, n-1) + fib(memo, n-2);
        return memo[n];
    }
};
```

# Traveral without Memorization
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
public:
    int fib(int n) {
        if(n < 1){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int prev = 0, cur = 1;
        for(int i = 2; i <= n; i++){
            int sum = prev + cur;
            prev = cur;
            cur = sum;
        }
        return cur;
    }
};
```