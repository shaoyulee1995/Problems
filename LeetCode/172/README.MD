# Factorial Trailing Zeroes

- Time Complexity: O(log<sub>5</sub>N)
- Space Complexity: O(1)
  - N as n

```java
class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while(n >= 1){
            res += n/5;
            n /= 5;
        }
        return res;
    }
}
```

- Time Complexity: O(log<sub>5</sub>N)
- Space Complexity: O(1)
  - N as n
  
```java
class Solution {
    public int trailingZeroes(int n) {
        return n == 0? 0: n/5 + trailingZeroes(n/5);
    }
}
```