# Power of Two

- Time Complexity: O(logN)
- Space Complexity: O(1)
  - N as n

```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0){
            return false;
        }
        while(n > 1){
            if(n%2 == 1){
                return false;
            }
            n /= 2;
        }
        return n%2 == 0;
    }
}
```
