# Minimum Operations to Make Array Equal

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as n

```java
class Solution {
    public int minOperations(int n) {
        int res = 0;
        while(n > 0){
            res += (n-1);
            n-=2;
        }
        return res;
    }
}
```
