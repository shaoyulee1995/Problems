# Score of a String

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public int scoreOfString(String s) {
        int res = 0;
        for(int i = 1; i < s.length(); i++){
            res += Math.abs(s.charAt(i-1) - s.charAt(i));
        }
        return res;
    }
}
```
