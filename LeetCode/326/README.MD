# Power of Three

- Time Complexity: O(log<sub>3</sub>(N))
- Space Complexity: O(1)
    - N as n

```java
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n < 1){
            return false;
        }
        while(n % 3 == 0){
            n /= 3;
        }
        return n == 1;
    }
}
```
