# Power of Three

# Math

- Time Complexity: O(log3(N))
- Space Complexity: O(1)

```
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
