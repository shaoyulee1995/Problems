# Three Divisors

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as n

```java
class Solution {
    public boolean isThree(int n) {
        int d = 1;
        for(int i = 2; i <= n && d <= 3; i++){
            if(n%i == 0){
                d++;
            }
        }
        return d==3;
    }
}
```
