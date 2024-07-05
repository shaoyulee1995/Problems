# Power of Four

- Time Complexity: O(logN)
- Space Complexity: O(1)
  - N as n

```
class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0){
            return false;
        }
        while(n > 1){
            if(n%4 != 0){
                return false;
            }
            n /= 4;
        }
        return n == 1;
    }
}
```
