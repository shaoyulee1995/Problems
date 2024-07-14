# Consecutive Characters

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public int maxPower(String s) {
        int i = 0,
            j = 0,
            res = 0;
        while(j < s.length()){
            while(j < s.length() && s.charAt(i) == s.charAt(j)){
                j++;
            }
            res = Math.max(res, j-i);
            i = j;
        }
        return res;
    }
}
```
