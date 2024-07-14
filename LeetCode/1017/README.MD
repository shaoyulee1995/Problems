# Convert to Base -2

# StringBuilder

- Time Complexity: O(logN)
- Space Complexity: O(logN)
  - N as n

```java
class Solution {
    public String baseNeg2(int n) {
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            sb.append(n & 1);
            n = -(n >> 1);
        }
        return sb.length() > 0? sb.reverse().toString(): "0";
    }
}
```
