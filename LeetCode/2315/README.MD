# Count Asterisks

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public int countAsterisks(String s) {
        int bar = 0,
            res = 0;
        for(char c: s.toCharArray()){
            if(c == '|'){
                bar++;
            }
            if(bar % 2 == 0 && c == '*'){
                res++;
            }
        }
        return res;
    }
}
```
